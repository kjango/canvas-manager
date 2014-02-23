/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
    public void logar(){
        boolean resposta = login.logar();       
        login = new Login();
    }

    public LoginController() {
        login = new Login();
    }
    
}
