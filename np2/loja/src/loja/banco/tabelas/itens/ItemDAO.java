package loja.banco.tabelas.itens;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import loja.banco.Conexao;

/**
 * ItemDAO
 */
public class ItemDAO {

    private PreparedStatement ps = null;

    public int inserir(ItemBean itens) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into itens(numero, serie, item, codPneu, qtde, preco)values(?,?,?,?,?,?)";
        ResultSet rs;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(itens.getNumero()));
            ps.setString(2, String.valueOf(itens.getSerie()));
            ps.setString(3, String.valueOf(itens.getItem()));
            ps.setString(4, String.valueOf(itens.getCodPneu()));
            ps.setString(5, String.valueOf(itens.getQtde()));
            ps.setString(6, String.valueOf(itens.getPreco()));
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);
                rs.close();
                System.out.println("Inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
        return id;
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

    public List<ItemBean> pesquisarPorNumero(char[] numero) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where numero = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(numero));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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

    public List<ItemBean> pesquisarPorSerie(char[] serie) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where serie = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(serie));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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

    public List<ItemBean> pesquisarPorPneu(int codPneu) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where codPneu = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codPneu));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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

    public List<ItemBean> pesquisarPorItem(String item) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where item = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(item));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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

    public List<ItemBean> pesquisarPorQtde(String qtde) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where qtde = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(qtde));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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

    public List<ItemBean> pesquisarPorPreco(String preco) {
        Connection con = Conexao.abrirConexao();
        String sql = "select * from itens where preco = ?";
        ResultSet rs = null;
        List<ItemBean> listaItens = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(preco));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ItemBean notaBean = new ItemBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setItem(rs.getInt("item"));
                    notaBean.setCodPneu(rs.getInt("codPneu"));
                    notaBean.setQtde(rs.getInt("qtde"));
                    notaBean.setPreco(new BigDecimal(rs.getString("preco")));
                    listaItens.add(notaBean);
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
