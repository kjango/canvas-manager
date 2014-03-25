package DAO;

import Base.Status;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Status
 * @author Francisco
 */

public class SituacaoDAO {
    
    public SituacaoDAO(){
    
    }

    public Map<String, Integer> getAllStatus() {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM situacao;";
        
        ResultSet rs;
        Map<String, Integer> resultado = new HashMap<String, Integer>();
        
        try {
            CallableStatement stmt = con.prepareCall(query);            
            rs = stmt.executeQuery();
            while(rs.next())
            {
                resultado.put(rs.getString("descricao"), rs.getInt("id"));
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no SQL do getAllStatus");
            e.printStackTrace();            
        }
        return resultado;
    }
    
}
