package core.solution.deepleads.request;

import core.solution.deepleads.model.crudModel.EnderecoModel;
import core.solution.deepleads.model.crudModel.Role;

import java.util.List;
import java.util.Set;

public class UserRequest {

    private static final long serialVersionUID = 1L;

    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    private String senha;


    private Set<Role> roles;

    private List<EnderecoModel> endereco;



}
