package core.solution.deepleads.repository.miningDadosRepository;




import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenericEntityRepository  extends JpaRepository<LeadsModel, Long> {


    List<LeadsModel> findByPhone(String phone);




}
