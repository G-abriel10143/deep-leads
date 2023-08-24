package core.solution.deepleads.controller.miningDadosController;

import core.solution.deepleads.model.crudModel.UsuarioModel;
import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.crudRepository.UsuarioRepository;
import core.solution.deepleads.request.UrlRequest;
import core.solution.deepleads.response.LeadsResponse;
import core.solution.deepleads.service.miningDadosService.GenericEntityServiceImpl;
import core.solution.deepleads.service.miningDadosService.MiningService;
import core.solution.deepleads.service.miningDadosService.UrlServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("generate-leads-by-id")
    public ResponseEntity<LeadsResponse> generateLeadsByUser(@RequestBody UrlRequest urlRequest, @RequestParam Long id) {
        try {

            //          List<LeadsModel> leadsModelList = miningService.extractWebData(urlRequest);
            List<LeadsModel> leadsModelList = new ArrayList<>();
            List<UrlModel> urlModels = new ArrayList<>();

            UsuarioModel usuarioModel  = usuarioRepository.findById(id).orElse(null);

            if (usuarioModel != null) {

                for (int i = 0; i < 5; i++) {
                    LeadsModel leadsModel = new LeadsModel();
                    leadsModel.setPlace("Sao paulo");
                    leadsModel.setStars("3,2");
                    leadsModel.setRating("250");
                    leadsModel.setName("pastelaria " + i);
                    leadsModel.setPhone("11957818539");
                    leadsModelList.add(leadsModel);
                }

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
    @ApiResponse(responseCode = "200", description = "Usuarios encontrados com sucesso!", content = @Content(schema = @Schema(implementation = UrlModel.class)))
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



