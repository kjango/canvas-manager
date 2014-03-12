package DAO;

import Base.Usuario;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo Usuario
 * @author Francisco
 */

public class UsuarioDAO {


    public int getIdUsuario(String usuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id FROM usuario where email =?;";
        
        ResultSet rs;
        int cod =-1;
        
        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                cod = rs.getInt("id");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no SQL do getIdUsuario");
            e.printStackTrace();            
        }
        return cod;
    }

    public int salvar(Usuario usuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO usuario () ;";
        
        ResultSet rs;
        int cod =-1;
        
        try {
            CallableStatement stmt = con.prepareCall(query);
            //stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                cod = rs.getInt("id");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no SQL do getIdUsuario");
            e.printStackTrace();            
        }
        return cod;
    }
    
}
