/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modelo.Login;

/**
 *
 * @author falbernaz
 */
public class LoginController {
    
    private static LoginController instance = null;
    
    protected LoginController(){
        
    }

    public static LoginController getInstance(){
        if (instance == null){
            instance = new LoginController();
        }
        return instance;
    }    
    
    public int logar(Login login){
        return login.logar();
    }
    
}
