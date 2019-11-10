package loja.banco.tabelas.pneus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loja.banco.Conexao;

/**
 * PneuDAO
 */
public class PneuDAO {

    private PreparedStatement ps = null;

    public void inserir(PneuBean pneus) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into pneus(codPneu, descricao, medidas, preco, ativo)values(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(pneus.getCodPneu()));
            ps.setString(2, pneus.getDescricao());
            ps.setString(3, pneus.getMedidas());
            ps.setString(4, String.valueOf(pneus.getPreco()));
            ps.setString(5, String.valueOf(pneus.getAtivo()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public void alterar(PneuBean pneus) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update pneus set codPneu = ?, descricao = ?, medidas = ?, preco = ?, ativo = ?";
        sql += " where codCli = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(pneus.getCodPneu()));
            ps.setString(2, pneus.getDescricao());
            ps.setString(3, pneus.getMedidas());
            ps.setString(4, String.valueOf(pneus.getPreco()));
            ps.setString(5, String.valueOf(pneus.getAtivo()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int codPneu) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from pneus where codPneu = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codPneu));
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

    public List<PneuBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from pneus ";
        ResultSet rs = null;
        List<PneuBean> listaPneus = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PneuBean cb = new PneuBean();
                    cb.setCodPneu(rs.getInt("codPneu"));
                    cb.setDescricao(rs.getString("descricao"));
                    cb.setMedidas(rs.getString("medidas"));
                    cb.setPreco(rs.getBigDecimal("preco"));
                    cb.setAtivo(rs.getString("ativo").toCharArray());
                    listaPneus.add(cb);
                }
                System.out.println("Listado com sucesso!");
                return listaPneus;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
