package core.solution.deepleads.repository.miningDadosRepository;


import core.solution.deepleads.model.miningDadosModel.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, UUID> {

    Optional<CadastroModel> findByCpf(String cpf);

    Optional<CadastroModel> findByEmail(String email);
}
