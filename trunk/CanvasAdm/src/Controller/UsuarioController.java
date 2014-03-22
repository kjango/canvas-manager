/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;

/**
 *
 * @author kji
 */
public class UsuarioController {

    public boolean podeCriar(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.podeCriar(id);
    }
    
    public int getUsuario(String email){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getIdUsuario(email);
    }

    public String getEmail(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getEmail(id);
    }
    
}
