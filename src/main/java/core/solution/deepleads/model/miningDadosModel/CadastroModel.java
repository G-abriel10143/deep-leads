package core.solution.deepleads.model.miningDadosModel;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Data
public class CadastroModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 2)
    private String idade;

    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 1)
    private String sexo;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 15)
    private String senha;




}
