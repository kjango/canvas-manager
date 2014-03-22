package Modelo;

import Base.Usuario;
import DAO.CredencialDAO;
import DAO.UsuarioDAO;


/**
 * Classe da Camada de Modelo para cadastro de usuário
 * @author ROSANA
 */
public class CadastroCM {
    
    private Usuario usuario;
    private CredencialCM credencial;

    /**
     * Construtor da classe
     * @param usuario Objeto usuario
     * @param credencial Objeto credencial
     */
    public CadastroCM(Usuario usuario, CredencialCM credencial) {
        this.usuario = usuario;
        this.credencial = credencial;
    }

    public CadastroCM() {
        usuario= new Usuario();
        credencial = new CredencialCM();
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
    public CredencialCM getCredencial() {
        return credencial;
    }

    /**
     * Método que define o objeto credencial
     * @param credencial Objeto credencial
     */
    public void setCredencial(CredencialCM credencial) {
        this.credencial = credencial;
    }
    
    public void salvar(){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int id = usuarioDao.inserir(usuario);  
        credencial.setId_usuario(id);
        CredencialDAO credencialDao = new CredencialDAO();
        int result = credencialDao.salvar(credencial);
        
    }
    
    
}
