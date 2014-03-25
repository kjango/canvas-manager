/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Login;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rosana
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public String logar() throws IOException{
        int resposta = login.logar();       
        if(resposta !=-1){
            return "logado.xhmtl?faces-redirect=true&user="+login.getUsuario()+"&id="+resposta;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não cadastrado! Para fazer um novo cadastro clique em 'Novo Cadastro'.", ""));
        return "";
    }

    public LoginController() {
        login = new Login();
    }
    
}
