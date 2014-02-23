package DAO;

import Hibernate.Credencial;
import Modelo.Login;
import Util.HibernateUtil;
import org.hibernate.Query;
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
    
    public boolean existeCredencial(Login login){
        /*
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("count(*) FROM Credencial where usuaio= :user and senha= :senha");
        query.setParameter("user", login.getUsuario());
        query.setParameter("senha", login.getSenha());
        int result = (int) query.uniqueResult();
        if(result == 1){
            return true;
        }
        return false;/*/
        return true;
    }

    public CredencialDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    

}
