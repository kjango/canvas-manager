package Modelo;

/**
 * Classe de apoio para a função de alteração de senha
 * @author ROSANA
 */
public class AlteraSenha {
    
    private String usuario;
    private String senha1;
    private String senha2;

    public AlteraSenha(String usuario, String senha1, String senha2) {
        this.usuario = usuario;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    
}
