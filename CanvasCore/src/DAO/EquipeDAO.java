package DAO;

import Hibernate.Equipe;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Equipe
 * @author Rosana
 */
public class EquipeDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Equipe na Base de Dados
     * @param equipe objeto a ser persistido no Banco de Dados
     */
    public void save(Equipe equipe) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(equipe);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Equipe na Base de Dados
     * @param equipe objeto a ser alterado
     */
    public void update(Equipe equipe) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(equipe);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Equipe
     * @param equipe objeto a ser removido do Banco de Dados
     */
    public void delete(Equipe equipe) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(equipe);
        session.getTransaction().commit();
    }

}
