package DAO;

import Hibernate.Status;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Status
 * @author Francisco
 */

public class StatusDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Status na Base de Dados
     * @param status objeto a ser persistido no Banco de Dados
     */
    public void save(Status status) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(status);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Status na Base de Dados
     * @param status objeto a ser alterado
     */
    public void update(Status status) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(status);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Status
     * @param status objeto a ser removido do Banco de Dados
     */
    public void delete(Status status) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(status);
        session.getTransaction().commit();
    }
}
