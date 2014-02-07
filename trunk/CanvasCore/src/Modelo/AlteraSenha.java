package Modelo;

/**
 * Classe de apoio para a função de alteração de senha
 * @author ROSANA
 */
public class AlteraSenha {
    
    private String usuario;
    private String senha1;
    private String senha2;

    /**
     * Construtor da classe
     * @param usuario O objeto usuario
     * @param senha1 String contendo o texto do campo senha1
     * @param senha2 String contendo o texto co campo senha2, para comparação
     */
    public AlteraSenha(String usuario, String senha1, String senha2) {
        this.usuario = usuario;
        this.senha1 = senha1;
        this.senha2 = senha2;
    }

    /**
     * Método que retorna o objeto usuario
     * @return objeto usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que define o objeto usuario
     * @param usuario objeto usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que retorna a senha1 do usuario
     * @return String contendo a senha1
     */
    public String getSenha1() {
        return senha1;
    }

    /**
     * Método que define a senha1 do usuario
     * @param senha1 String contendo a senha1
     */
    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    /**
     * Método que retorna a senha2 do usuario
     * @return String contendo a senha2
     */
    public String getSenha2() {
        return senha2;
    }

    /**
     * Método que define a senha2 do usuario
     * @param senha2 String contendo a senha2
     */
    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    
}
