package DAO;

import Hibernate.Avaliacao;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Avaliacao
 * @author Rosana
 */
public class AvaliacaoDAO {

    
    
    private Session session;
    
    /**
     * Persiste um objeto Avaliacao na Base de Dados
     * @param avaliacao objeto a ser persistido no Banco de Dados
     */
    public void save(Avaliacao avaliacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(avaliacao);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Avaliacao na Base de Dados
     * @param avaliacao objeto a ser alterado
     */
    public void update(Avaliacao avaliacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(avaliacao);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Avaliacao
     * @param avaliacao objeto a ser removido do Banco de Dados
     */
    public void delete(Avaliacao avaliacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(avaliacao);
        session.getTransaction().commit();
    }

}
