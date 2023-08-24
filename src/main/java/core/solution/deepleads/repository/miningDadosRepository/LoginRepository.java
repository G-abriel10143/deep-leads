package core.solution.deepleads.repository.miningDadosRepository;


import core.solution.deepleads.model.miningDadosModel.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, UUID> {
}
