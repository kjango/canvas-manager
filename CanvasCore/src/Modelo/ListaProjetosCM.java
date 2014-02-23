
package Modelo;

import Base.Projeto;
import Base.Usuario;

/**
 * Classe da camada de modelo para a lista de projetos de um usuário
 * @author ROSANA
 */
public class ListaProjetosCM {
    private Usuario usuario;
    private Projeto projetoAtivo;
    private Projeto projetoParte;

    /**
     * Construtor da classe
     * @param usuario Objeto usuario
     * @param projetoAtivo Objeto projeto que define qual o projeto ativo do usuario
     * @param projetoParte Objeto projeto que define qual projoto tem o usuario como membro
     */
    public ListaProjetosCM(Usuario usuario, Projeto projetoAtivo, Projeto projetoParte) {
        this.usuario = usuario;
        this.projetoAtivo = projetoAtivo;
        this.projetoParte = projetoParte;
    }

    /**
     * Método que retorna o objeto usuario
     * @return Objeto usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método que define o objeto usuario
     * @param usuario Objeto usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que retorna o objeto projeto que seja o ativo para o usuario
     * @return Objeto projeto que seja o ativo para o usuario
     */
    public Projeto getProjetoAtivo() {
        return projetoAtivo;
    }

    /**
     * Método que define o objeto projeto que seja o ativo para o usuario
     * @param projetoAtivo Objeto projeto que seja o ativo para o usuario
     */
    public void setProjetoAtivo(Projeto projetoAtivo) {
        this.projetoAtivo = projetoAtivo;
    }

    /**
     * Método que retorna o objeto projeto que possua o usuario como membro
     * @return Objeto projeto que possua o usuario como membro
     */
    public Projeto getProjetoParte() {
        return projetoParte;
    }

    /**
     * Método que define o objeto projeto que possua o usuario como membro
     * @param projetoParte Objeto projeto que possua o usuario como membro
     */
    public void setProjetoParte(Projeto projetoParte) {
        this.projetoParte = projetoParte;
    }
    
    
}
