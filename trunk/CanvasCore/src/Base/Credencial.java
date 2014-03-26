/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Base;

import DAO.UsuarioDAO;
import java.sql.Date;

/**
 *
 * @author Rosana
 */
public class Credencial {
    
    protected int id_usuario;
    protected String senha;
    private Date atualizado_em;

    public Credencial(int id_usuario, String senha, Date atualizado_em) {
        this.id_usuario = id_usuario;
        this.senha = senha;
        this.atualizado_em = atualizado_em;
    }

    public Credencial() {
        
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
//        UsuarioDAO ud = new UsuarioDAO();
//        ud.guardaSenha(id_usuario, senha);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }
    
    
}
