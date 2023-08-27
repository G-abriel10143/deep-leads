package core.solution.deepleads.service.miningDadosService;

import core.solution.deepleads.model.crudModel.UsuarioModel;
import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.crudRepository.UsuarioRepository;
import core.solution.deepleads.request.UrlRequest;
import core.solution.deepleads.response.LeadsResponse;
import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import core.solution.deepleads.service.crudService.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteWebService {

    MiningService miningService = new MiningService();

    @Autowired
    private GoogleMapsService googleMapsService;

    @Autowired
    private UrlServiceImpl urlModelRepository;

    @Autowired
    private GenericEntityServiceImpl genericEntityService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LeadsResponse PostLeadsByUserService( UrlRequest urlRequest, Long id) throws InterruptedException {
        List<UrlModel> urlModels = new ArrayList<>();

        List<LeadsModel> leadsModelList = miningService.extractWebData(urlRequest);



        for (LeadsModel leadsModel: leadsModelList ) {
            GeocodingResponse geocodingResponse =googleMapsService.getInfosAdress(leadsModel.getPlusCode());

            double latitude = geocodingResponse.getResults().get(0).getGeometry().getLocation().getLat();
            double logitude = geocodingResponse.getResults().get(0).getGeometry().getLocation().getLng();
            String coutry = geocodingResponse.getResults().get(0).getAddressComponents().get(2).getShortName();
            String State = geocodingResponse.getResults().get(0).getAddressComponents().get(3).getShortName();


            leadsModel.setLatitude(String.valueOf(latitude));
            leadsModel.setLongitude(String.valueOf(logitude));
            leadsModel.setCountry(coutry);
            leadsModel.setState(State);

        }

        UsuarioModel usuarioModel  = usuarioRepository.findById(id).orElse(null);
        if (usuarioModel != null) {

            UrlModel urlModel = new UrlModel(urlRequest, leadsModelList);
            urlModels.add(urlModel);
            List<UrlModel> urlsDoUsuario =  usuarioModel.getUrlModels();
            urlsDoUsuario.addAll(urlModels);
            usuarioModel.setUrlModels(urlsDoUsuario);
            usuarioRepository.save(usuarioModel);
            LeadsResponse leadsResponse = new LeadsResponse(urlModel);

            return leadsResponse;

        }

    return null;
    }




}
