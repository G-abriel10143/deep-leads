package core.solution.deepleads.repository.crudRepository;

import core.solution.deepleads.model.crudModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByNome(String name);

}
