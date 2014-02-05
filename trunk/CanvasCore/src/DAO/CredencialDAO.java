package DAO;

import Hibernate.Credencial;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Credencial
 * @author Rosana
 */
public class CredencialDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Credencial na Base de Dados
     * @param credencial objeto a ser persistido no Banco de Dados
     */
    public void save(Credencial credencial) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(credencial);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Credencial na Base de Dados
     * @param credencial objeto a ser alterado
     */
    public void update(Credencial credencial) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(credencial);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Credencial
     * @param credencial objeto a ser removido do Banco de Dados
     */
    public void delete(Credencial credencial) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(credencial);
        session.getTransaction().commit();
    }

}
