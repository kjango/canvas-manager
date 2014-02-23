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
public class Resposta {
    
    private int id;
    private int id_pergunta;
    private int id_projeto;
    private String texto;
    private Date criado_em;
    private Date atualizado_em;

    public Resposta(int id, int id_pergunta, int id_projeto, String texto, Date criado_em, Date atualizado_em) {
        this.id = id;
        this.id_pergunta = id_pergunta;
        this.id_projeto = id_projeto;
        this.texto = texto;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
