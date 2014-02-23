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
public class Parecer {
    
    private int id;
    private int id_admin;
    private String comentario;
    private int id_resultado;
    private int id_projeto;
    private Date criado_em;
    private Date modificado_em;

    public Parecer(int id, int id_admin, String comentario, int id_resultado, 
            int id_projeto, Date criado_em, Date modificado_em) {
        this.id = id;
        this.id_admin = id_admin;
        this.comentario = comentario;
        this.id_resultado = id_resultado;
        this.id_projeto = id_projeto;
        this.criado_em = criado_em;
        this.modificado_em = modificado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(int id_resultado) {
        this.id_resultado = id_resultado;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    public Date getModificado_em() {
        return modificado_em;
    }

    public void setModificado_em(Date modificado_em) {
        this.modificado_em = modificado_em;
    }
    
    
}
