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
public class Equipe {
    
    private int id_usuario;
    private int id_projeto;
    private Date adicionado_em;

    public Equipe(int id_usuario, int id_projeto, Date adicionado_em) {
        this.id_usuario = id_usuario;
        this.id_projeto = id_projeto;
        this.adicionado_em = adicionado_em;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Date getAdicionado_em() {
        return adicionado_em;
    }

    public void setAdicionado_em(Date adicionado_em) {
        this.adicionado_em = adicionado_em;
    }
    
    
}
