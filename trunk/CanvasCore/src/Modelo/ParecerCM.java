package Modelo;

import Hibernate.Parecer;
import Hibernate.Resultado;
import Hibernate.Usuario;

/**
 *
 * @author ROSANA
 */
public class ParecerCM {
    private Usuario admin;
    private Parecer parecer;
    private Resultado resultado;

    public ParecerCM(Usuario admin, Parecer parecer, Resultado resultado) {
        this.admin = admin;
        this.parecer = parecer;
        this.resultado = resultado;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public Parecer getParecer() {
        return parecer;
    }

    public void setParecer(Parecer parecer) {
        this.parecer = parecer;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    
}
