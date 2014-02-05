package DAO;

import Hibernate.Historico;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Historico
 * @author Rosana
 */
public class HistoricoDAO {
    
     private Session session;
    
    /**
     * Persiste um objeto Historico na Base de Dados
     * @param historico objeto a ser persistido no Banco de Dados
     */
    public void save(Historico historico) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(historico);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Historico na Base de Dados
     * @param historico objeto a ser alterado
     */
    public void update(Historico historico) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(historico);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Historico
     * @param historico objeto a ser removido do Banco de Dados
     */
    public void delete(Historico historico) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(historico);
        session.getTransaction().commit();
    }
}
