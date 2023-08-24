package core.solution.deepleads.service.miningDadosService;



import core.solution.deepleads.model.miningDadosModel.CadastroModel;
import core.solution.deepleads.repository.miningDadosRepository.CadastroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {


    @Autowired(required = false)
    private CadastroRepository cadastroRepository;

    @Transactional
    public CadastroModel save(CadastroModel cadastroModel) {
        return cadastroRepository.save(cadastroModel);
    }

    public List<CadastroModel> buscarCadastros(){
        List<CadastroModel> listCadastros = cadastroRepository.findAll();
        return listCadastros;
    }

}
