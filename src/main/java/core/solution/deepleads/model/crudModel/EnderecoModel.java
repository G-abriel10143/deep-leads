package core.solution.deepleads.model.crudModel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_DL_ENDERECO")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuarioModel;

}
