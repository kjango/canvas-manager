/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.CredencialDAO;

/**
 *
 * @author Rosana
 */
public class Login {
    private String usuario;
    private String senha;
    private CredencialDAO cred;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login() {
       this.cred = new CredencialDAO(); 
    }
    
    public boolean logar(){        
        //return (cred.existeCredencial(this));
        return true;
    }
}