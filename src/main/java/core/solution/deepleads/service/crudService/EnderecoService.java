package core.solution.deepleads.service.crudService;


import core.solution.deepleads.feign.EnderecoFeign;
import core.solution.deepleads.feignModels.EnderecoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoFeign enderecoFeign;

    public EnderecoService(EnderecoFeign enderecoFeign) {
        this.enderecoFeign = enderecoFeign;
    }

    public EnderecoResponseModel executa(String request) {
        return enderecoFeign.buscaEnderecoCep(request);
    }
}
