package DAO;

import Hibernate.Situacao;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Situacao
 * @author Francisco
 */

public class SituacaoDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Situacao na Base de Dados
     * @param situacao objeto a ser persistido no Banco de Dados
     */
    public void save(Situacao situacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(situacao);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Situacao na Base de Dados
     * @param situacao objeto a ser alterado
     */
    public void update(Situacao situacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(situacao);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Situacao
     * @param situacao objeto a ser removido do Banco de Dados
     */
    public void delete(Situacao situacao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(situacao);
        session.getTransaction().commit();
    }
}
