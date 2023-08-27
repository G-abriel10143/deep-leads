package core.solution.deepleads.response;

import core.solution.deepleads.model.crudModel.UsuarioModel;

public class UsuarioResponse {

    Long id;

    String name;

    String email;

    String messageLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessageLogin() {
        return messageLogin;
    }

    public void setMessageLogin(String messageLogin) {
        this.messageLogin = messageLogin;
    }

    public UsuarioResponse(UsuarioModel usuarioModel, String messageLogin) {
        this.id = usuarioModel.getId();
        this.name = usuarioModel.getNome();
        this.email = usuarioModel.getEmail();
        this.messageLogin = messageLogin    ;
    }
}
