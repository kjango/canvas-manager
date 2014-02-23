/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Base;

import java.sql.Date;

/**
 *
 * @author Rosana
 */
public class Historico {
    
    private int id;
    private String senha;
    private Date atualizado_em;

    public Historico(int id, String senha, Date atualizado_em) {
        this.id = id;
        this.senha = senha;
        this.atualizado_em = atualizado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
