/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rosana
 */
public class ConnectionFactory {
    

    private static final String user = "postgres";
    private static final String password = "root";
    private static final String database = "Canvas";
    private static final String host = "localhost";
    private static final String port = "5432";
    
    private static final String user2 = "postgres";
    private static final String password2 = "postgres";
    private static final String database2 = "Eceel-tec";
    private static final String host2 = "localhost";
    private static final String port2 = "5432";


    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password;

            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();

            try {
                Class.forName("org.postgresql.Driver");
                System.err.println("conectar ao debian");
                con = null;

                String url = "jdbc:postgresql://" + host2 + ":" + port2 + "/" + database2 + "?user=" + user2 + "&password=" + password2;
                con = DriverManager.getConnection(url);
            } catch (Exception i) {
                e.printStackTrace();
                System.err.println("FALHA AO SE CONECTAR AO DEBIAN");
            }



        }
        return con;
    }
}