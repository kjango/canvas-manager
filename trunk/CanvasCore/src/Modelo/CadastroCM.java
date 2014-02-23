package Modelo;

import Base.Credencial;
import Base.Usuario;


/**
 * Classe da Camada de Modelo para cadastro de usuário
 * @author ROSANA
 */
public class CadastroCM {
    private Usuario usuario;
    private Credencial credencial;

    /**
     * Construtor da classe
     * @param usuario Objeto usuario
     * @param credencial Objeto credencial
     */
    public CadastroCM(Usuario usuario, Credencial credencial) {
        this.usuario = usuario;
        this.credencial = credencial;
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
     * Método que retorna o objeto credencial
     * @return Objeto credencial
     */
    public Credencial getCredencial() {
        return credencial;
    }

    /**
     * Método que define o objeto credencial
     * @param credencial Objeto credencial
     */
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    
    
}
