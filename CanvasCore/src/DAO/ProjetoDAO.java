package DAO;

import Hibernate.Projeto;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Projeto
 * @author Rosana
 */
public class ProjetoDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Projeto na Base de Dados
     * @param projeto objeto a ser persistido no Banco de Dados
     */
    public void save(Projeto projeto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(projeto);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Projeto na Base de Dados
     * @param projeto objeto a ser alterado
     */
    public void update(Projeto projeto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(projeto);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Projeto
     * @param projeto objeto a ser removido do Banco de Dados
     */
    public void delete(Projeto projeto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(projeto);
        session.getTransaction().commit();
    }
}
