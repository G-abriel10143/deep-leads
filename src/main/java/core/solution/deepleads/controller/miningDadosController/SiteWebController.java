package core.solution.deepleads.controller.miningDadosController;

import core.solution.deepleads.model.crudModel.UsuarioModel;
import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.crudRepository.UsuarioRepository;
import core.solution.deepleads.request.UrlRequest;
import core.solution.deepleads.response.LeadsListResponse;
import core.solution.deepleads.response.LeadsResponse;
import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import core.solution.deepleads.service.crudService.GoogleMapsService;
import core.solution.deepleads.service.miningDadosService.GenericEntityServiceImpl;
import core.solution.deepleads.service.miningDadosService.MiningService;
import core.solution.deepleads.service.miningDadosService.UrlServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Url;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mineracao")
@Tag(name = "Mining de dados", description = "Serviços responsaveis pela mineracao de dados")
public class SiteWebController {

    MiningService miningService = new MiningService();

    @Autowired
    private UrlServiceImpl urlModelRepository;

    @Autowired
    private GenericEntityServiceImpl genericEntityService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GoogleMapsService googleMapsService;


    @GetMapping("get/url/by-user")
    @Operation(summary = "Realiza a Mineração de dados persistindo diretamente na tabela de dados, ATENÇÃO: Não está atrelada a nenhum usuário.", description = "Retorna uma lista com todos os usuários em paginação")
    @ApiResponse(responseCode = "200", description = "Usuários encontrados com sucesso!", content = @Content(schema = @Schema(implementation = UrlRequest.class)))
    @ApiResponse(responseCode = "404", description = "Usuários não encontrados!")
    public ResponseEntity<Page<UrlModel>> getUrlModelByUser(
            @RequestParam Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id).orElse(null);

        if (usuarioModel == null) {
            return ResponseEntity.notFound().build();
        }

        List<UrlModel> allUrlModels = usuarioModel.getUrlModels();

        int start = page * size;
        int end = Math.min(start + size, allUrlModels.size());

        List<UrlModel> urlModels = allUrlModels.subList(start, end);

        Pageable pageable = PageRequest.of(page, size);
        Page<UrlModel> pageUrlModels = new PageImpl<>(urlModels, pageable, allUrlModels.size());

        return ResponseEntity.ok(pageUrlModels);
    }



    @GetMapping("get/leads/by-id")
    @Operation(summary = "Recupera leads de um usuário por ID.", description = "Retorna uma lista paginada de leads associados a um usuário com base em seu ID.")
    @ApiResponse(responseCode = "200", description = "Leads encontrados com sucesso!", content = @Content(schema = @Schema(implementation = Page.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado!")
    public ResponseEntity<Page<LeadsListResponse>> getAllLeadsByUser(
            @RequestParam Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id).orElse(null);

        if (usuarioModel == null) {
            return ResponseEntity.notFound().build();
        }

        List<LeadsModel> leadsModels = new ArrayList<>();
        for (UrlModel urlModel : usuarioModel.getUrlModels()) {
            leadsModels.addAll(urlModel.getLeadsModels());
        }

        int start = page * size;
        int end = Math.min(start + size, leadsModels.size());

        List<LeadsListResponse> leadsListResponses = new ArrayList<>();
        for (int i = start; i < end; i++) {
            LeadsModel leadsModel = leadsModels.get(i);
            LeadsListResponse leadsListResponse = new LeadsListResponse(leadsModel);
            leadsListResponses.add(leadsListResponse);
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<LeadsListResponse> pageLeadsListResponses = new PageImpl<>(leadsListResponses, pageable, leadsModels.size());

        return ResponseEntity.ok(pageLeadsListResponses);
    }

    @Operation(summary = "Realiza a Mineracao de dados persistindo diretamente na tabela de dados, ATENÇÃO: Não está atrlada a nenhum usuario.", description = "Retorna uma lista com todos os usuarios em paginação")
    @ApiResponse(responseCode = "200", description = "Usuarios encontrados com sucesso!", content = @Content(schema = @Schema(implementation = UrlRequest.class)))
    @ApiResponse(responseCode = "404", description = "Usuarios não encontrados!")
    @PostMapping("generate/leads/by-id")
    public ResponseEntity<LeadsResponse> PostLeadsByUser(@RequestBody UrlRequest urlRequest, @RequestParam Long id) {
        try {
            List<UrlModel> urlModels = new ArrayList<>();
            List<LeadsModel> leadsModelList = miningService.extractWebData(urlRequest);
            UsuarioModel usuarioModel  = usuarioRepository.findById(id).orElse(null);


            for (LeadsModel leadsModel: leadsModelList ) {
                GeocodingResponse geocodingResponse =googleMapsService.getInfosAdress(leadsModel.getPlusCode());

                double latitude = geocodingResponse.getResults().get(0).getGeometry().getLocation().getLat();
                double logitude = geocodingResponse.getResults().get(0).getGeometry().getLocation().getLng();



                leadsModel.setLatitude(String.valueOf(latitude));
                leadsModel.setLongitude(String.valueOf(logitude));

            }

            if (usuarioModel != null) {
                UrlModel urlModel = new UrlModel(urlRequest, leadsModelList);
                urlModels.add(urlModel);
                List<UrlModel> urlsDoUsuario =  usuarioModel.getUrlModels();
                urlsDoUsuario.addAll(urlModels);
                usuarioModel.setUrlModels(urlsDoUsuario);
                usuarioRepository.save(usuarioModel);
                LeadsResponse leadsResponse = new LeadsResponse(urlModel);

                return ResponseEntity.ok(leadsResponse);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Realiza a Mineracao de dados persistindo diretamente na tabela de dados, ATENÇÃO: Não está atrlada a nenhum usuario.", description = "Retorna uma lista com todos os usuarios em paginação")
    @ApiResponse(responseCode = "200", description = "Usuarios encontrados com sucesso!", content = @Content(schema = @Schema(implementation = UrlRequest.class)))
    @ApiResponse(responseCode = "404", description = "Usuarios não encontrados!")
    @PostMapping("/getDatas")
    public ResponseEntity<LeadsResponse> siteUrl(@RequestBody UrlRequest urlRequest) {
        System.out.println("SiteWebController.siteUrl");
        System.out.println("url = " + urlRequest);
        try {
//          List<LeadsModel> leadsModelList = miningService.extractWebData(urlRequest);
            List<LeadsModel> leadsModelList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                LeadsModel leadsModel = new LeadsModel();
                leadsModel.setPlace("Sao paulo");
                leadsModel.setStars("3,2");
                leadsModel.setRating("250");
                leadsModel.setName("pastelaria " + i);
                leadsModel.setPhone("11957818539");
                leadsModelList.add(leadsModel);
            }

            UrlModel urlModel = new UrlModel();
            urlModel.setUrl(urlRequest.getUrl());
            urlModel.setKeys(urlRequest.getKeys());
            urlModel.setTypeSearch(urlRequest.getTypeSearch());
            urlModel.setLeadsModels(leadsModelList);
            urlModel.setDataMining(LocalDateTime.now());
            urlModelRepository.saveUrl(urlModel);
            LeadsResponse leadsResponse = new LeadsResponse(urlModel);

            return ResponseEntity.ok(leadsResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}



