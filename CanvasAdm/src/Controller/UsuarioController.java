/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Modelo.PProjetoCM;
import View.VPrincipalUsuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kji
 */
public class UsuarioController {

    private static UsuarioController instance = null;
    
    protected UsuarioController(){
        
    }

    public static UsuarioController getInstance(){
        if (instance == null){
            instance = new UsuarioController();
        }
        return instance;
    }    
    
    public boolean podeCriar(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.podeCriar(id);
    }
    
    public int getIdUsuario(String email){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getIdUsuario(email);
    }

    public String getEmail(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getEmail(id);
    }
    
    public ArrayList<Integer> getTodosProjetos(int idUsuario){
        ArrayList<Integer> ret = new ArrayList<>();
        return ret;
    }

    public int getTipoUsuario(int usuarioId) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getTipoUsuario(usuarioId);
    }
    

}
