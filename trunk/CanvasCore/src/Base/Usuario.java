/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Base;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosana
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String curso;
    private int status_curso;
    private Date data_conclusao_curso;
    private Date data_registro;
    private Date autalizado_em;
    private int id_tipo;

    public Usuario(int id, String nome, String email, String curso, int status_curso, 
            Date data_conclusao_curso, Date data_registro, Date autalizado_em, int id_tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.status_curso = status_curso;
        this.data_conclusao_curso = data_conclusao_curso;
        this.data_registro = data_registro;
        this.autalizado_em = autalizado_em;
        this.id_tipo = id_tipo;
    }

    public Usuario() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getStatus_curso() {
        return status_curso;
    }

    public void setStatus_curso(int status_curso) {
        this.status_curso = status_curso;
    }

    public Date getData_conclusao_curso_Date() {
        return this.data_conclusao_curso;
    }

    public String getData_conclusao_curso() {
        if(data_conclusao_curso == null){
            return "";
        }
        String parse [] = data_conclusao_curso.toString().split("-");
        return parse[2]+parse[1]+parse[0];
    }
    
    public void setData_conclusao_curso(String data_conclusao_curso) throws ParseException {       
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        this.data_conclusao_curso = new java.sql.Date(fmt.parse(data_conclusao_curso).getTime());
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public Date getAutalizado_em() {
        return autalizado_em;
    }

    public void setAutalizado_em(Date autalizado_em) {
        this.autalizado_em = autalizado_em;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public boolean validar() {
        if(id <=0){return false;}
        if(nome.isEmpty() || nome.length() <= 1){return false;}
        if(email.isEmpty() || email.length() <= 1){return false;}
        if(curso.isEmpty() || curso.length() <= 1){return false;}
        return true;
    }
    
    
}
