package DAO;

import Hibernate.Resultado;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Credencial
 * @author Rosana
 */
public class ResultadoDAO {
    
    private Session session;
    
    /**
     * Persiste um objeto Resultado na Base de Dados
     * @param resultado objeto a ser persistido no Banco de Dados
     */
    public void save(Resultado resultado) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(resultado);
        session.getTransaction().commit();
    }
    
    /**
     * Altera um objeto Resultado na Base de Dados
     * @param resultado objeto a ser alterado
     */
    public void update(Resultado resultado) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.update(resultado);
        session.getTransaction().commit();
    }
    
    /**
     * Remove da Base de Dados um objeto do tipo Resultado
     * @param resultado objeto a ser removido do Banco de Dados
     */
    public void delete(Resultado resultado) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.delete(resultado);
        session.getTransaction().commit();
    }
}
