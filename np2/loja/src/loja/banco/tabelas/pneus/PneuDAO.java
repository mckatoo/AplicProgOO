package loja.banco.tabelas.pneus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PneuDAO
 */
public class PneuDAO {
    private Connection con;

    public PneuDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(PneuBean pneus) throws SQLException {
        String sql = "insert into pneus(codPneu, descricao, medidas, preco, ativo)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pneus.getCodPneu());
            ps.setString(2, pneus.getDescricao());
            ps.setString(3, pneus.getMedidas());
            ps.setBigDecimal(4, pneus.getPreco());
            ps.setString(5, String.valueOf(pneus.getAtivo()));
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao inserir.";
    }

    public String alterar(PneuBean pneus) throws SQLException {
        String sql = "update pneus set codPneu = ?, descricao = ?, medidas = ?, preco = ?, ativo = ?";
        sql += " where codPneu = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pneus.getCodPneu());
            ps.setString(2, pneus.getDescricao());
            ps.setString(3, pneus.getMedidas());
            ps.setBigDecimal(4, pneus.getPreco());
            ps.setString(5, String.valueOf(pneus.getAtivo()));
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao alterar.";
    }

    public String excluir(PneuBean pneus) throws SQLException {
        String sql = "delete from pneus where codPneu = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(pneus.getCodPneu()));
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao excluir.";
    }

    public List<PneuBean> listarTodos() throws SQLException {
        String sql = "select * from pneus ";
        List<PneuBean> listapneus = new ArrayList<PneuBean>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PneuBean cb = new PneuBean();
                    cb.setCodPneu(rs.getInt("codPneu"));
                    cb.setDescricao(rs.getString("descricao"));
                    cb.setMedidas(rs.getString("medidas"));
                    cb.setPreco(rs.getBigDecimal("preco"));
                    cb.setAtivo(rs.getString("ativo").charAt(0));
                    listapneus.add(cb);
                }
                return listapneus;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}