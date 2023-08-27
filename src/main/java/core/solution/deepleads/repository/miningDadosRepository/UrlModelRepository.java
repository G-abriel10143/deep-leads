package core.solution.deepleads.repository.miningDadosRepository;


import core.solution.deepleads.model.miningDadosModel.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlModelRepository extends JpaRepository<UrlModel, Long> {



}
