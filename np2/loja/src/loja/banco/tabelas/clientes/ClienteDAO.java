package loja.banco.tabelas.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import loja.banco.Conexao;

/**
 * ClienteDAO
 */
public class ClienteDAO {
        private PreparedStatement ps = null;

    public void inserir(ClienteBean clientes) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into clientes(nome, endereco, estado)values(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getNome());
            ps.setString(2, clientes.getEndereco());
            ps.setString(3, String.valueOf(clientes.getEstado()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public void alterar(ClienteBean clientes) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update clientes set nome = ?,endereco = ?,estado = ?";
        sql += " where codCli = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clientes.getNome());
            ps.setString(2, clientes.getEndereco());
            ps.setString(3, String.valueOf(clientes.getEstado()));
            ps.setString(4, String.valueOf(clientes.getCodCli()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public String excluir(int codCli) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "delete from clientes where codCli = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codCli));
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

    public List<ClienteBean> listarTodos() throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from clientes ";
        ResultSet rs = null;
        List<ClienteBean> listaClientes = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClienteBean cb = new ClienteBean();
                    cb.setCodCli(rs.getInt("codCli"));
                    cb.setNome(rs.getString("nome"));
                    cb.setEndereco(rs.getString("endereco"));
                    cb.setEstado(rs.getString("estado").toCharArray());
                    listaClientes.add(cb);
                }
                System.out.println("Listado com sucesso!");
                return listaClientes;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps, rs);
        }
        return null;
    }

}
