/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Login;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rosana
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Login login;
    
    private ArrayList<Login> logins;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public void logar(){
        login.logar();
       
    }

    public LoginController() {
        this.login = new Login();
        this.logins = new ArrayList();
    }
    
}
