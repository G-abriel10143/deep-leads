package core.solution.deepleads.service.miningDadosService;

import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.repository.miningDadosRepository.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenericEntityServiceImpl {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    public void saveGenericEntity(List<LeadsModel> leadsModel) {

        try {
            System.out.println("Persistindo dados...");
            genericEntityRepository.saveAll(leadsModel);

        } catch (Exception e) {
            System.out.println("ERRO ao persistir!");
            e.printStackTrace();
        }
    }

}
