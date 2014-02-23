/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import DAO.CredencialDAO;
import Modelo.Login;

/**
 *
 * @author Rosana
 */
public class Canvas {

    public static void main(String[] args) {
        Login login = new Login("Rosana", "teste");
        System.out.println(login.logar());
    }

}
