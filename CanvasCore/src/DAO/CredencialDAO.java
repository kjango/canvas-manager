package DAO;

import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Credencial
 * @author Rosana
 */
public class CredencialDAO {

    public boolean login(int user, String senha) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT count(*) as soma FROM credencial where id=? and senha=?;";
        
        ResultSet rs;
        int cod =-1;
        
        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, user);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                cod = rs.getInt("soma");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no SQL do logar - CredencialDao");
            e.printStackTrace();            
        }
        if(cod==1)
        {
            return true;
        }
        return false;
    }
    
    

}
