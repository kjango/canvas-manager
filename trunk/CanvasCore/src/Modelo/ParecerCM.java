package Modelo;

import Hibernate.Parecer;
import Hibernate.Resultado;
import Hibernate.Usuario;

/**
 * Classe da camada de modelo para os pareceres gerados pelos administradores
 * @author ROSANA
 */
public class ParecerCM {
    private Usuario admin;
    private Parecer parecer;
    private Resultado resultado;

    /**
     * Construtor da classe
     * @param admin Objeto usuario que é o administrador
     * @param parecer Objeto parecer contendo o parecer do administrador
     * @param resultado Objeto resultado contendo o resultado definido pelo administrador
     */
    public ParecerCM(Usuario admin, Parecer parecer, Resultado resultado) {
        this.admin = admin;
        this.parecer = parecer;
        this.resultado = resultado;
    }

    /**
     * Método que retorna o objeto usuario, no caso, o administrador
     * @return Objeto usuario, no caso, o administrador
     */
    public Usuario getAdmin() {
        return admin;
    }

    /**
     * Método que define o objeto usuario, no caso, o administrador
     * @param admin Objeto usuario, no caso, o administrador
     */
    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    /**
     * Método que retorna o objeto parecer
     * @return Objeto parecer contendo o parecer do administrador
     */
    public Parecer getParecer() {
        return parecer;
    }

    /**
     * Método que define o objeto parecer
     * @param parecer Objeto parecer contendo o parecer do administrador
     */
    public void setParecer(Parecer parecer) {
        this.parecer = parecer;
    }

    /**
     * Método que retorna o objeto resultado
     * @return Objeto resultado contendo o resultado definido pelo administrador
     */
    public Resultado getResultado() {
        return resultado;
    }

    /**
     * Método que define o objeto resultado
     * @param resultado Objeto resultado contendo o resultado definido pelo administrador
     */
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    
}
