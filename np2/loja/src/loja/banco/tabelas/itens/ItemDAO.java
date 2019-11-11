package loja.banco.tabelas.itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loja.banco.Conexao;

/**
 * ItemDAO
 */
public class ItemDAO {

    private PreparedStatement ps = null;

    public void inserir(ItemBean itens) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into itens(numero, serie, item, codPneu, qtde, preco)values(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(itens.getNumero()));
            ps.setString(2, String.valueOf(itens.getSerie()));
            ps.setString(3, String.valueOf(itens.getItem()));
            ps.setString(4, String.valueOf(itens.getCodPneu()));
            ps.setString(5, String.valueOf(itens.getQtde()));
            ps.setString(6, String.valueOf(itens.getPreco()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public void alterar(ItemBean itens) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update itens set codPneu = ?, qtde = ?, preco = ?";
        sql += " where numero = ? & serie = ? & item = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(itens.getCodPneu()));
            ps.setString(2, String.valueOf(itens.getQtde()));
            ps.setString(3, String.valueOf(itens.getPreco()));
            ps.setString(4, String.valueOf(itens.getNumero()));
            ps.setString(5, String.valueOf(itens.getSerie()));
            ps.setString(6, String.valueOf(itens.getItem()));
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
        String sql = "delete from itens where numero = ?";
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

    public List<ItemBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens ";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean item = new ItemBean();
                    item.setNumero(rs.getString("numero").toCharArray());
                    item.setSerie(rs.getString("serie").toCharArray());
                    item.setItem(rs.getInt("item"));
                    item.setCodPneu(rs.getInt("codPneu"));
                    item.setQtde(rs.getInt("qtde"));
                    item.setPreco(rs.getBigDecimal("preco"));
                    listaItens.add(item);
                }
                System.out.println("Listado com sucesso!");
                return listaItens;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
