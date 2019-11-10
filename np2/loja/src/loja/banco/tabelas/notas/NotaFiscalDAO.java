package loja.banco.tabelas.notas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import loja.banco.Conexao;
import loja.banco.tabelas.clientes.ClienteBean;

/**
 * ClienteDAO
 */
public class NotaFiscalDAO {

    private PreparedStatement ps = null;

    public void inserir(NotaFiscalBean notas) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into notaFiscal(numero, serie, codCli, data, cancelada)values(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(notas.getNumero()));
            ps.setString(2, String.valueOf(notas.getSerie()));
            ps.setString(3, String.valueOf(notas.getCodCli()));
            ps.setString(4, String.valueOf(notas.getData()));
            ps.setString(5, String.valueOf(notas.getCancelada()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public void alterar(NotaFiscalBean notas) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update notaFiscal set serie = ?, codCli = ?, data = ?, cancelada = ?";
        sql += " where numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Arrays.toString(notas.getSerie()));
            ps.setString(2, String.valueOf(notas.getCodCli()));
            ps.setString(3, String.valueOf(notas.getData()));
            ps.setString(4, String.valueOf(notas.getCancelada()));
            ps.setString(5, Arrays.toString(notas.getNumero()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int numero) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from notaFiscal where codCli = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(numero));
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            Conexao.fecharConexao(con, ps);
        }
        return null;
    }

    public List<NotaFiscalBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from notaFiscal ";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean cb = new NotaFiscalBean();
                    cb.setNumero(rs.getString("numero").toCharArray());
                    cb.setSerie(rs.getString("serie").toCharArray());
                    cb.setCodCli(rs.getInt("codCli"));
                    cb.setData(rs.getDate("data"));
                    cb.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(cb);
                }
                System.out.println("Listado com sucesso!");
                return listaNotas;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

    public List<NotaFiscalBean> pesquisar(char[] numero, char[] serie, int codCli, char[] cancelada, Date dataInicial, Date dataFinal) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "SELECT * FROM notaFiscal where numero = ? or serie = ? or cancelada = ? or codCli = ? or data between ? and ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(numero));
            ps.setString(2, String.valueOf(serie));
            ps.setString(5, String.valueOf(cancelada));
            ps.setString(3, String.valueOf(codCli));
            ps.setString(4, String.valueOf(dataInicial));
            ps.setString(4, String.valueOf(dataFinal));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean cb = new NotaFiscalBean();
                    cb.setNumero(rs.getString("numero").toCharArray());
                    cb.setSerie(rs.getString("serie").toCharArray());
                    cb.setCodCli(rs.getInt("codCli"));
                    cb.setData(rs.getDate("data"));
                    cb.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(cb);
                }
                System.out.println("Listado com sucesso!");
                return listaNotas;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
