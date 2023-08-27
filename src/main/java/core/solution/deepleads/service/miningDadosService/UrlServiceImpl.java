package core.solution.deepleads.service.miningDadosService;


import core.solution.deepleads.model.crudModel.UsuarioModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.crudRepository.UsuarioRepository;
import core.solution.deepleads.repository.miningDadosRepository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlServiceImpl {

    @Autowired
    private UrlModelRepository urlRepo;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UrlModel saveUrl(UrlModel urlModel) {
        return urlRepo.save(urlModel);
    }

    public List<UrlModel> getUrlByUserId(Long id) {
       UsuarioModel usuarioModel = usuarioRepository.findById(id).orElse(null);

        return usuarioModel.getUrlModels();


    }







}
