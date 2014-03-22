package DAO;

import Base.Usuario;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo
 * Usuario
 *
 * @author Francisco
 */
public class UsuarioDAO {

    public int getIdUsuario(String usuario) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id FROM usuario where email =?;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
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
        String query = "INSERT INTO usuario (nome, email, curso, status_curso, data_conclusao_curso, id_tipo) values(?,?,?,?,?,1) returnin id;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCurso());
            stmt.setInt(4, usuario.getStatus_curso());
            stmt.setDate(5, usuario.getData_conclusao_curso());
            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
            //System.out.println("Erro no SQL do getIdUsuario");
            //e.printStackTrace();            
        }
        return cod;
    }
    //testar

    public ArrayList<Integer> getProjetosLider(int id_usuario) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id FROM projeto where lider =?;";

        ResultSet rs;
        ArrayList<Integer> projetos = null;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id_usuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                projetos.add(rs.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getProjetosLider");
            e.printStackTrace();
        }
        return projetos;
    }
    //testar

    public ArrayList<Integer> getProjetosParticipa(int id_usuario) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id FROM projeto where id in (SELECT id_projeto FROM equipe where id_usuario = ?);";

        ResultSet rs;
        ArrayList<Integer> projetos = null;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id_usuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                projetos.add(rs.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getProjetosParticipa");
            e.printStackTrace();
        }
        return projetos;
    }
    
   
}
