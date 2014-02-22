package DAO;

import Hibernate.Tipousuario;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Tipousuario
 * @author Francisco
 */

public class TipoUsuarioDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Tipousuario na Base de Dados
     * @param tipousuario objeto a ser persistido no Banco de Dados
     */
    public void save(Tipousuario tipousuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(tipousuario);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Tipousuario na Base de Dados
     * @param tipousuario objeto a ser alterado
     */
    public void update(Tipousuario tipousuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(tipousuario);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Tipousuario
     * @param tipousuario objeto a ser removido do Banco de Dados
     */
    public void delete(Tipousuario tipousuario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(tipousuario);
        session.getTransaction().commit();
    }
}
