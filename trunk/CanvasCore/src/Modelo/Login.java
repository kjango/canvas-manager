/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.CredencialDAO;
import DAO.UsuarioDAO;

/**
 *
 * @author Rosana
 */
public class Login {

    private String usuario;
    private String senha;

    public Login() {
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

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

    public int logar() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int user = usuarioDao.getIdUsuario(usuario);
        System.out.print(user);
        if (user != -1) {
            CredencialDAO credencialDao = new CredencialDAO();            
            if(credencialDao.login(user, senha)==1){
                return user;
            }
        }
        return -1;
    }

}
