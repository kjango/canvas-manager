package DAO;

import Hibernate.Parecer;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Parecer
 * @author Rosana
 */
public class ParecerDAO {
    
     private Session session;
    
    /**
     * Persiste um objeto Parecer na Base de Dados
     * @param parecer objeto a ser persistido no Banco de Dados
     */
    public void save(Parecer parecer) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(parecer);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Parecer na Base de Dados
     * @param parecer objeto a ser alterado
     */
    public void update(Parecer parecer) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(parecer);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Parecer
     * @param parecer objeto a ser removido do Banco de Dados
     */
    public void delete(Parecer parecer) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(parecer);
        session.getTransaction().commit();
    }
}
