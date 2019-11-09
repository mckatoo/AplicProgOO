package loja.banco.tabelas.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ItemDAO
 */
public class ItemDAO {
    private Connection con;

    public ItemDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(ItemBean itens) throws SQLException {
        String sql = "insert into itens(numero, serie, item, codPneu, qtde, preco)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(itens.getNumero()));
            ps.setString(2, String.valueOf(itens.getSerie()));
            ps.setString(3, String.valueOf(itens.getItem()));
            ps.setString(4, String.valueOf(itens.getCodPneu()));
            ps.setString(5, String.valueOf(itens.getQtde()));
            ps.setString(6, String.valueOf(itens.getPreco()));
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao inserir.";
    }

    public String alterar(ItemBean itens) throws SQLException {
        String sql = "update itens set numero = ?, serie = ?, item = ?, codPneu = ?, qtde = ?, preco = ?";
        sql += " where item = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(itens.getNumero()));
            ps.setString(2, String.valueOf(itens.getSerie()));
            ps.setString(3, String.valueOf(itens.getItem()));
            ps.setString(4, String.valueOf(itens.getCodPneu()));
            ps.setString(5, String.valueOf(itens.getQtde()));
            ps.setString(6, String.valueOf(itens.getPreco()));
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao alterar.";
    }

    public String excluir(ItemBean itens) throws SQLException {
        String sql = "delete from itens where item = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(itens.getItem()));
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao excluir.";
    }

    public List<ItemBean> listarTodos() throws SQLException {
        String sql = "select * from itens ";
        List<ItemBean> listaitens = new ArrayList<ItemBean>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean cb = new ItemBean();
                    cb.setNumero(rs.getString("numero").charAt(0));
                    cb.setSerie(rs.getString("serie").charAt(0));
                    cb.setItem(rs.getInt("item"));
                    cb.setCodPneu(rs.getInt("codPneu"));
                    cb.setQtde(rs.getString("qtde").charAt(0));
                    cb.setPreco(rs.getBigDecimal("preco"));
                    listaitens.add(cb);
                }
                return listaitens;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}