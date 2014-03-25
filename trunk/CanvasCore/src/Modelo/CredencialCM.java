/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Base.Credencial;
import DAO.CredencialDAO;
import java.sql.Date;

/**
 *
 * @author Rosana
 */
public class CredencialCM extends Credencial {
    
    private String senha2;

    public CredencialCM(String senha2, int id_usuario, String senha, Date atualizado_em) {
        super(id_usuario, senha, atualizado_em);
        this.senha2 = senha2;
    }

    public CredencialCM() {
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public boolean update() {
        CredencialDAO credencialDao = new CredencialDAO();
        return credencialDao.update(id_usuario, senha);
    }
    
    public int salvar() {
        CredencialDAO credencialDao = new CredencialDAO();
        return credencialDao.salvar(id_usuario, senha);
    }

}
