package core.solution.deepleads.model.crudModel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_DL_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String nome;

}
