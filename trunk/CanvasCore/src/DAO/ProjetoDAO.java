package DAO;

import Base.Projeto;
import Modelo.PPerguntaCM;
import Modelo.VProjetoUsuarioCM;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
            con.close();

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
            con.close();

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
            con.close();

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
            con.close();

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
            con.close();

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
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.isMembro");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean podeEditar(int usuarioId, int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT id_situacao, lider FROM projeto WHERE id = ?;";

        ResultSet rs;
        int sit = -1;
        int lider = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                sit = rs.getInt("id_situacao");
                lider = rs.getInt("lider");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.podeEditar");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (sit == 1 && lider == usuarioId) {
            return true;
        } else {
            return false;
        }
    }

    public VProjetoUsuarioCM getBasicoProjeto(int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT p.nome as nomeProjeto, p.id as idProjeto, u.nome as nomeLider, u.id as liderId, p.id_situacao as statusProjeto FROM projeto p JOIN usuario u ON p.lider = u.id WHERE p.id = ?;";

        ResultSet rs;
        VProjetoUsuarioCM ret = null;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                ret = new VProjetoUsuarioCM(rs.getString("nomeProjeto"), rs.getInt("idProjeto"), rs.getString("nomelider"), rs.getInt("liderId"), rs.getInt("statusProjeto"), -1);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getBasicoProjeto");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ret;
    }

    public ArrayList<String> getNomesMembros(int projetoId) {

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT u.nome FROM usuario u JOIN equipe e ON e.id_usuario = u.id  WHERE e.id_projeto = ?";

        ResultSet rs;
        ArrayList<String> membros = new ArrayList<>();

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                membros.add(rs.getString("nome"));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getNomesMembros");
            e.printStackTrace();
        }
        return membros;
    }

    public HashMap<String, ArrayList<PPerguntaCM>> getPerguntasVProjetoUsuario(int projetoId) {
        HashMap<String, ArrayList<PPerguntaCM>> ret = new HashMap<>();

        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM pergunta";

        String bloco = "";
        ResultSet rs;

        try {
            CallableStatement stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                bloco = rs.getString("bloco");
                if (!ret.containsKey(bloco)) {
                    ret.put(bloco, new ArrayList<PPerguntaCM>());
                }
                ret.get(bloco).add(new PPerguntaCM(rs.getString("descricao"), "", "Sem dicas", bloco, rs.getInt("id"), projetoId));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getRespostasVProjetoUsuario");
            e.printStackTrace();
        }

        return ret;
    }

    public String getResposta(int perguntaId, int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT texto FROM resposta WHERE id_pergunta = ? AND id_projeto = ?";

        String resp = "";
        ResultSet rs;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, perguntaId);
            stmt.setInt(2, projetoId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                resp = rs.getString("texto");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.getResposta");
            e.printStackTrace();
        }

        return resp;
    }

    public int salvaResposta(int perguntaId, int projetoId, String resposta) {
        Connection con = ConnectionFactory.getConnection();
        String query = "UPDATE resposta SET texto = ? WHERE id_pergunta = ? AND id_projeto = ? RETURNING id";

        int id = -1;
        ResultSet rs;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, resposta);
            stmt.setInt(2, perguntaId);
            stmt.setInt(3, projetoId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.salvaResposta");
            e.printStackTrace();
        }

        return id;
    }

    public int insereResposta(int perguntaId, int projetoId, String resposta) {
        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO resposta (texto, id_pergunta, id_projeto) VALUES (?, ?, ?) RETURNING id";

        int id = -1;
        ResultSet rs;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, resposta);
            stmt.setInt(2, perguntaId);
            stmt.setInt(3, projetoId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.insereResposta");
            e.printStackTrace();
        }

        return id;
    }

    public boolean podeEnviar(int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT (SELECT COUNT (id) FROM pergunta) = (SELECT COUNT (id) FROM resposta where id_projeto = ?);";

        ResultSet rs;
        boolean resp = false;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                resp = rs.getBoolean(1);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.podeEnviar");
            e.printStackTrace();
        }

        return resp;
    }

    public int enviaProjetoAvaliacao(int projetoId) {
        Connection con = ConnectionFactory.getConnection();
        String query = "UPDATE projeto set id_situacao = 2 WHERE id = ? RETURNING id_situacao;";

        ResultSet rs;
        int resp = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, projetoId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                resp = rs.getInt(1);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Erro no SQL do ProjetoDAO.enviaProjetoAvaliacao");
            e.printStackTrace();
        }
        return resp;

    }
}
