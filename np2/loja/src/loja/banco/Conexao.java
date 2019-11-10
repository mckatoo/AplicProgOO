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
    
    private static String IP = "campus1-iesi.ddns.net";
    private static String PORTA = "9005";
    private static String BANCO = "lojaServer";
    private static String USER = "mckatoo";
    private static String PASS = "zicasp2";
//    private static String IP = "127.0.0.1";
//    private static String PORTA = "3306";
//    private static String BANCO = "loja";
//    private static String USER = "mckatoo";
//    private static String PASS = "12345";
    private static final String URL = "jdbc:mysql://"+ IP +":"+ PORTA +"/"+ BANCO;

    public static String getIP() {
        return IP;
    }

    public static void setIP(String IP) {
        Conexao.IP = IP;
    }

    public static String getPORTA() {
        return PORTA;
    }

    public static void setPORTA(String PORTA) {
        Conexao.PORTA = PORTA;
    }

    public static String getBANCO() {
        return BANCO;
    }

    public static void setBANCO(String BANCO) {
        Conexao.BANCO = BANCO;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conexao.USER = USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static void setPASS(String PASS) {
        Conexao.PASS = PASS;
    }
    
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