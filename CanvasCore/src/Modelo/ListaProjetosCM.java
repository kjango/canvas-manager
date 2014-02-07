
package Modelo;

import Hibernate.Projeto;
import Hibernate.Usuario;

/**
 *
 * @author ROSANA
 */
public class ListaProjetosCM {
    private Usuario usuario;
    private Projeto projetoAtivo;
    private Projeto projetoParte;

    public ListaProjetosCM(Usuario usuario, Projeto projetoAtivo, Projeto projetoParte) {
        this.usuario = usuario;
        this.projetoAtivo = projetoAtivo;
        this.projetoParte = projetoParte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Projeto getProjetoAtivo() {
        return projetoAtivo;
    }

    public void setProjetoAtivo(Projeto projetoAtivo) {
        this.projetoAtivo = projetoAtivo;
    }

    public Projeto getProjetoParte() {
        return projetoParte;
    }

    public void setProjetoParte(Projeto projetoParte) {
        this.projetoParte = projetoParte;
    }
    
    
}
