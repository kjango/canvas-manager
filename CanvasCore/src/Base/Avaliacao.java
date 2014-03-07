package Base;

import java.sql.Date;

/**
 * Classe base para a avaliação dos projetos
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

    /**
     * Construtor da classe.
     * @param id Id da avaliação.
     * @param id_usuario Id do usuário que avalia.
     * @param id_resposta Id da resposta.
     * @param nota Nota da avaliação.
     * @param comentario Comentário da avaliação.
     * @param criado_em Data de criação da avaliação.
     * @param atualizado_em Data da última modificação da avaliação.
     */
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

    /**
     * Getter do Id da avaliação.
     * @return Id da avaliação.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter do Id da avaliação.
     * @param id Id da avaliação.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter do Id do usuário.
     * @return Id do usuário.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Setter do Id do usuário.
     * @param id_usuario Id do usuário.
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Getter do Id da resposta.
     * @return Id da resposta.
     */
    public int getId_resposta() {
        return id_resposta;
    }

    /**
     * Setter do Id da resposta.
     * @param id_resposta Id da resposta.
     */
    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    /**
     * Getter da nota da avaliação.
     * @return Nota da avaliação.
     */
    public int getNota() {
        return nota;
    }

    /**
     * Setter da nota da avaliação.
     * @param nota Nota da avaliação.
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Getter do comentário da avaliação.
     * @return Comentário da avaliação.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Setter do comentário da avaliação.
     * @param comentario Comentário da avaliação.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Getter da data de criação.
     * @return Data de criação.
     */
    public Date getCriado_em() {
        return criado_em;
    }

    /**
     * Setter da data de criação.
     * @param criado_em Data de criação.
     */
    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    /**
     * Getter da data da última atualização.
     * @return Data da última atualização.
     */
    public Date getAtualizado_em() {
        return atualizado_em;
    }

    /**
     * Setter data da última atualização.
     * @param atualizado_em Data da última atualização.
     */
    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }
 
    
}
