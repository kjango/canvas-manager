package DAO;

import Hibernate.Resposta;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Resposta
 * @author Rosana
 */
public class RespostaDAO {    
    
    private Session session;
    
    /**
     * Persiste um objeto Resposta na Base de Dados
     * @param resposta objeto a ser persistido no Banco de Dados
     */
    public void save(Resposta resposta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(resposta);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Resposta na Base de Dados
     * @param resposta objeto a ser alterado
     */
    public void update(Resposta resposta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(resposta);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Resposta
     * @param resposta objeto a ser removido do Banco de Dados
     */
    public void delete(Resposta resposta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(resposta);
        session.getTransaction().commit();
    }
}
