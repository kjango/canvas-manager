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
public class Avaliacao {
    
    private int id;
    private int id_usuario;
    private int id_resposta;
    private int nota;
    private String comentario;
    private Date criado_em;
    private Date atualizado_em;

    public Avaliacao(int id, int id_usuario, int id_resposta, int nota, 
            String comentario, Date criado_em, Date atualizado_em) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_resposta = id_resposta;
        this.nota = nota;
        this.comentario = comentario;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    public Date getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }
 
    
}
