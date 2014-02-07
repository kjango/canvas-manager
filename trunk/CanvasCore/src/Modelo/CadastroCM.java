package Modelo;

import Hibernate.Credencial;
import Hibernate.Usuario;

/**
 *
 * @author ROSANA
 */
public class CadastroCM {
    private Usuario usuario;
    private Credencial credencial;

    public CadastroCM(Usuario usuario, Credencial credencial) {
        this.usuario = usuario;
        this.credencial = credencial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    
    
}
