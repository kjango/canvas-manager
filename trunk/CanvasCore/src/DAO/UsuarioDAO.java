package DAO;

import Base.Usuario;
import Modelo.PProjetoCM;
import Modelo.ProjetoCM;
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
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getIdUsuario");
            e.printStackTrace();
        }
        return cod;
    }

    public int inserir(Usuario usuario) {

        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO usuario (nome, email, curso, status_curso, data_conclusao_curso, id_tipo) values(?,?,?,?,?,?) returning id;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCurso());
            stmt.setInt(4, usuario.getStatus_curso());
            stmt.setDate(5, usuario.getData_conclusao_curso_Date());
            stmt.setInt(6, 1);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("id");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.inserir");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        return cod;
    }

    public int validarUsuario(String email) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT count(email) as total FROM usuario where email =?;";

        ResultSet rs;
        int tot = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.next()) {
                tot = rs.getInt("total");
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tot;
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
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getProjetosLider");
            e.printStackTrace();
        }
        return projetos;
    }
    //testar

    public ArrayList<Integer> getProjetosMembro(int id_usuario) {

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
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getProjetosMembro");
            e.printStackTrace();
        }
        return projetos;
    }

    public boolean podeCriar(int id_usuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT count(id) FROM projeto where lider = ? and id_situacao in (1, 2, 3, 4);";

        ResultSet rs;
        int count = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id_usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.podeCriar");
            e.printStackTrace();
        }
        if (count != 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getEmail(int id) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT email FROM usuario WHERE id =?;";

        ResultSet rs;
        String email = "";

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getEmail");
            e.printStackTrace();
        }
        return email;
    }

    public ArrayList<PProjetoCM> getTodosProjetosUsuario(int idUsuario) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT u.nome as nome_lider, u.id as id_lider, p.nome, p.id as id_proj, s.descricao FROM usuario u JOIN projeto p ON u.id = p.lider JOIN situacao s ON s.id = p.id_situacao WHERE u.id = ? AND p.id_situacao <> 7 UNION SELECT u.nome as nome_lider, u.id as id_lider, p.nome, p.id as id_proj, s.descricao FROM equipe e JOIN projeto p ON e.id_projeto = p.id JOIN usuario u ON p.lider = u.id JOIN situacao s ON s.id = p.id_situacao WHERE e.id_usuario = ? AND p.id_situacao <> 7;";

        ResultSet rs;
        ArrayList<PProjetoCM> res = new ArrayList<>();

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                res.add(new PProjetoCM(rs.getString("descricao"), rs.getString("nome_lider"), rs.getString("nome"), rs.getInt("id_lider"), idUsuario, rs.getInt("id_proj")));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getTodosProjetos");
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<PProjetoCM> getTodosProjetosAvaliador(int idUsuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT u.nome as nome_lider, u.id as id_lider, p.nome, p.id as id_proj, s.descricao FROM usuario u JOIN projeto p ON u.id = p.lider JOIN situacao s ON s.id = p.id_situacao WHERE p.id_situacao <> 7;";

        ResultSet rs;
        ArrayList<PProjetoCM> res = new ArrayList<>();

        try {
            CallableStatement stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                res.add(new PProjetoCM(rs.getString("descricao"), rs.getString("nome_lider"), rs.getString("nome"), rs.getInt("id_lider"), idUsuario, rs.getInt("id_proj")));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getTodosProjetosAvaliador");
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<PProjetoCM> getTodosProjetosAdmin(int idUsuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT u.nome as nome_lider, u.id as id_lider, p.nome, p.id as id_proj, s.descricao FROM usuario u JOIN projeto p ON u.id = p.lider JOIN situacao s ON s.id = p.id_situacao;";

        ResultSet rs;
        ArrayList<PProjetoCM> res = new ArrayList<>();

        try {
            CallableStatement stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                res.add(new PProjetoCM(rs.getString("descricao"), rs.getString("nome_lider"), rs.getString("nome"), rs.getInt("id_lider"), idUsuario, rs.getInt("id_proj")));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do UsuarioDAO.getTodosProjetosAdmin");
            e.printStackTrace();
        }
        return res;
    }

    public Usuario getUsuario(int id) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM USUARIO WHERE id=?;";

        ResultSet rs;
        Usuario usuario = null;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(id, rs.getString("nome"), rs.getString("email"), rs.getString("curso"), rs.getInt("status_curso"),
                    rs.getDate("data_conclusao_curso"), rs.getDate("data_registro"), rs.getDate("atualizado_em"), rs.getInt("id_tipo"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public int update(Usuario usuario) {
        Connection con = ConnectionFactory.getConnection();
        String query = "UPDATE usuario SET nome=?, email=?, curso=?, status_curso=?, data_conclusao_curso=?, id_tipo=?, atualizado_em='now' WHERE id=?;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCurso());
            stmt.setInt(4, usuario.getStatus_curso());
            stmt.setDate(5, usuario.getData_conclusao_curso_Date());
            stmt.setInt(6, usuario.getId_tipo());
            stmt.setInt(7, usuario.getId());
            cod = stmt.executeUpdate();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return cod;
    }

    public int getTipoUsuario(int usuarioId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id_tipo FROM usuario WHERE id = ?;";

        ResultSet rs;
        int tipo = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, usuarioId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                tipo = rs.getInt("id_tipo");
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return tipo;        
    }


}
