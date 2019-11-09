package loja.banco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conexao
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/loja";
    private static final String USER = "mckatoo";
    private static final String PASS = "12345";

    public static Connection abrirConexao() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void fecharConexao(Connection con) {
        try {
            con.close();
            System.out.println("Conexão fechada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps) {
        fecharConexao(con);
        try {
            if (ps != null) {
                ps.close();
            }
            System.out.println("PrepareStatment fechada.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement ps, ResultSet rs) {
        fecharConexao(con, ps);
        try {
            if (rs != null) {
                rs.close();
            }
            System.out.println("RecordSet fechada.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}