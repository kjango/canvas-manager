package DAO;

import Hibernate.Usuario;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Usuario
 * @author Francisco
 */

public class UsuarioDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Usuario na Base de Dados
     * @param usuario objeto a ser persistido no Banco de Dados
     */
    public void save(Usuario usuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Usuario na Base de Dados
     * @param usuario objeto a ser alterado
     */
    public void update(Usuario usuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Usuario
     * @param usuario objeto a ser removido do Banco de Dados
     */
    public void delete(Usuario usuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
    }
}
