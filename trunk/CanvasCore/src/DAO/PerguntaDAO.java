package DAO;

import Hibernate.Pergunta;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Pergunta
 * @author Rosana
 */
public class PerguntaDAO {    
    
    private Session session;
    
    /**
     * Persiste um objeto Pergunta na Base de Dados
     * @param pergunta objeto a ser persistido no Banco de Dados
     */
    public void save(Pergunta pergunta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(pergunta);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Pergunta na Base de Dados
     * @param pergunta objeto a ser alterado
     */
    public void update(Pergunta pergunta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(pergunta);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Pergunta
     * @param pergunta objeto a ser removido do Banco de Dados
     */
    public void delete(Pergunta pergunta) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(pergunta);
        session.getTransaction().commit();
    }
}
