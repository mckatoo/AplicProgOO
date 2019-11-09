package loja.banco.tabelas.nota_fiscal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * NotaFiscalDAO
 */
public class NotaFiscalDAO {
    private Connection con;

    public NotaFiscalDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(NotaFiscalBean nota_fiscal) throws SQLException {
        String sql = "insert into notaFiscal(numero, serie, codCli, data, cancelada)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(nota_fiscal.getNumero()));
            ps.setString(2, String.valueOf(nota_fiscal.getSerie()));
            ps.setInt(3, nota_fiscal.getCodCli());
            ps.setTimestamp(4, nota_fiscal.getData());
            ps.setString(5, String.valueOf(nota_fiscal.getCancelada()));
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao inserir.";
    }

    public String alterar(NotaFiscalBean nota_fiscal) throws SQLException {
        String sql = "update notaFiscal set data = ?, cancelada = ?";
        sql += " where numero = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setTimestamp(4, nota_fiscal.getData());
            ps.setString(5, String.valueOf(nota_fiscal.getCancelada()));
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao alterar.";
    }

    public String excluir(NotaFiscalBean nota_fiscal) throws SQLException {
        String sql = "delete from notaFiscal where numero = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(nota_fiscal.getNumero()));
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao excluir.";
    }

    public List<NotaFiscalBean> listarTodos() throws SQLException {
        String sql = "select * from notaFiscal ";
        List<NotaFiscalBean> listaNotaFiscal = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean cb = new NotaFiscalBean();
                    cb.setNumero(rs.getString("numero").charAt(0));
                    cb.setSerie(rs.getString("serie").charAt(0));
                    cb.setCodCli(rs.getInt("codCli"));
                    cb.setData(rs.getTimestamp("data"));
                    cb.setCancelada(rs.getString("cancelada").charAt(0));
                    listaNotaFiscal.add(cb);
                }
                return listaNotaFiscal;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}