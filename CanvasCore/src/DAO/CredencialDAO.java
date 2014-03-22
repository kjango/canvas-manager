package DAO;

import Base.Credencial;
import Util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Classe responsável pelas operações de Banco de Dados para os objetos do tipo
 * Credencial
 *
 * @author Rosana
 */
public class CredencialDAO {

    public boolean login(int user, String senha) {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT count(*) as soma FROM credencial where id_usuario=? and senha=?;";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, user);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cod = rs.getInt("soma");
            }

        } catch (SQLException e) {
            System.out.println("Erro no SQL do logar - CredencialDao");
            e.printStackTrace();
        }
        if (cod == 1) {
            return true;
        }
        return false;
    }

    public int salvar(Credencial credencial) {
        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO credencial (id_usuario, senha) values(?,?);";

        ResultSet rs;
        int cod = -1;

        try {
            CallableStatement stmt = con.prepareCall(query);
            stmt.setInt(1, credencial.getId_usuario());
            stmt.setString(2, credencial.getSenha());;
            cod = stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
            //System.out.println("Erro no SQL do salvar credencial");
            //e.printStackTrace();
        }
        return cod;
    }
}
