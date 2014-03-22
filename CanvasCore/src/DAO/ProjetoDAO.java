package DAO;

import Base.Projeto;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo
 * Projeto
 *
 * @author Rosana
 */
public class ProjetoDAO {

//    public Projeto getIdProjeto(String nomeProjeto) {
//
//        Connection con = ConnectionFactory.getConnection();
//        String query = "SELECT * FROM projeto where nome =?;";
//
//        ResultSet rs;
//        int cod = -1;
//
//        try {
//            CallableStatement stmt = con.prepareCall(query);
//            stmt.setString(1, nomeProjeto);
//            rs = stmt.executeQuery();
//            if (rs.next()) {
//                cod = rs.getInt("id");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Erro no SQL do getIdUsuario");
//            e.printStackTrace();
//        }
//        return cod;
//    }

    public int criar(Projeto projeto) {
        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO projeto (nome, lider, id_situacao) values(?,?,?) returning id;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, projeto.getNome());
            stmt.setInt(2, projeto.getLider());
            stmt.setInt(3, projeto.getId_situacao());

            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.criar");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cod;
    }

    public int getIdProjeto(String nomeProj) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id FROM projeto WHERE nome = ?;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, nomeProj);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getIdProjeto");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cod;        
    }

    public int inserirMembro(int id_membro, int id_projeto) {
        Connection con = ConnectionFactory.getConnection();
        String query = "Insert into equipe (id_usuario, id_projeto) values (?, ?) returning id_usuario;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id_membro);
            stmt.setInt(2, id_projeto);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("id_usuario");
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.inserirMembro");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cod;        
    }

    public int getIdLiderProjeto(int id_projeto) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT lider FROM projeto WHERE id = ?;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id_projeto);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("lider");
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getIdLiderProjeto");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cod;   
    }
    
    public ArrayList<Integer> getMembros(int projetoId) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id_usuario FROM equipe WHERE id_projeto = ?;";

        ResultSet rs;
        ArrayList<Integer> membros = null;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                membros.add(rs.getInt("id_usuario"));
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getMembros");
            e.printStackTrace();
        }
        return membros;
    }

    public boolean isMembro(int membroId, int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT count(id_usuario) FROM equipe WHERE id_usuario = ? AND id_projeto = ?;";

        ResultSet rs;
        int count = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, membroId);
            stmt.setInt(2, projetoId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.isMembro");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (count == 0){
            return false;
        }else{
            return true;
        }
    }
}
