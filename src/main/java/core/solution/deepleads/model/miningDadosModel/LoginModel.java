package core.solution.deepleads.model.miningDadosModel;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class LoginModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 15)
    private String senha;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cadastro_id", referencedColumnName = "id")
    private CadastroModel cadastroModels;
}
