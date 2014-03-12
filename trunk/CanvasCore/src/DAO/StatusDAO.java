package DAO;

import Base.Status;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Status
 * @author Francisco
 */

public class StatusDAO {
    
    public StatusDAO(){
    
    }

    public List<Status> getAllStatus() {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM status;";
        
        ResultSet rs;
        List<Status> resultado = new ArrayList();
        
        try {
            CallableStatement stmt = con.prepareCall(query);            
            rs = stmt.executeQuery();
            if(rs.next())
            {
                Status st = new Status(rs.getInt("id"), rs.getString("descricao"));
                resultado.add(st);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no SQL do getAllStatus");
            e.printStackTrace();            
        }
        return resultado;
    }
    
}
