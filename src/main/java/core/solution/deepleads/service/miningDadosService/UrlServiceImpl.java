package core.solution.deepleads.service.miningDadosService;


import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.miningDadosRepository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl {

    @Autowired
    private UrlModelRepository urlRepo;

    public UrlModel saveUrl(UrlModel urlModel) {
        return urlRepo.save(urlModel);
    }







}
