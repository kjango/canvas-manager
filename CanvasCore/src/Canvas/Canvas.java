/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import Base.Usuario;
import DAO.CredencialDAO;
import DAO.SituacaoDAO;
import DAO.UsuarioDAO;
import Modelo.Login;

/**
 *
 * @author Rosana
 */
public class Canvas {

    public static void main(String[] args) {
        Login login = new Login("Rosana", "teste");
        System.out.println(login.logar());
        
//        UsuarioDAO user = new UsuarioDAO();
//        Usuario u = user.getUsuario(1);
//        System.out.println(u.getData_conclusao_curso());
//        System.out.println(u.getData_conclusao_curso_Date());
    }

}
