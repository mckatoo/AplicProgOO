package loja.banco.tabelas.notas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import loja.banco.Conexao;
//import loja.uteis.FormataData;

/**
 * ClienteDAO
 */
public class NotaFiscalDAO {

    private PreparedStatement ps = null;
//    final DateTimeFormatter dataBR = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    final DateTimeFormatter dataUS = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public int inserir(NotaFiscalBean notas) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "insert into notaFiscal(numero, serie, codCli, data, cancelada)values(?,?,?,?,?)";
        ResultSet rs = null;
        int id = 0;

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(notas.getNumero()));
            ps.setString(2, String.valueOf(notas.getSerie()));
            ps.setString(3, String.valueOf(notas.getCodCli()));
            ps.setString(4, String.valueOf(notas.getData()));
            ps.setString(5, String.valueOf(notas.getCancelada()));
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
            Conexao.fecharConexao(con, ps, rs);
        }
        return id;
    }

    public void alterar(NotaFiscalBean notas) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "update notaFiscal set serie = ?, codCli = ?, data = ?, cancelada = ?";
        sql += " where numero = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(notas.getSerie()));
            ps.setString(2, String.valueOf(notas.getCodCli()));
            ps.setString(3, String.valueOf(notas.getData()));
            ps.setString(4, String.valueOf(notas.getCancelada()));
            ps.setString(5, String.valueOf(notas.getNumero()));
            if (ps.executeUpdate() > 0) {
                ps.getGeneratedKeys();
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
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal";
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(data);
//                    notaBean.setData(FormataData.UStoBR(data));
//                    LocalDate data = LocalDate.parse(rs.getString("data"), dataBR);
//                    notaBean.setData(data);
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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

    public List<NotaFiscalBean> pesquisarPorNumero(char[] numero) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal where numero = ?";
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal where numero = ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(numero));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(data);
//                    notaBean.setData(FormataData.UStoBR(data));
//                    LocalDate data = LocalDate.parse(rs.getString("data"), dataBR);
//                    notaBean.setData(data);
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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

    public List<NotaFiscalBean> pesquisarPorSerie(char[] serie) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal where serie = ?";
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal where serie = ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(serie));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(data);
//                    notaBean.setData(FormataData.UStoBR(data));
//                    LocalDate data = LocalDate.parse(rs.getString("data"), dataBR);
//                    notaBean.setData(data);
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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

    public List<NotaFiscalBean>  pesquisarPorCliente(int codCli) {
        Connection con = Conexao.abrirConexao();
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal where codCli = ?";
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal where codCli = ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(codCli));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(data);
//                    notaBean.setData(FormataData.UStoBR(data));
//                    LocalDate data = LocalDate.parse(rs.getString("data"), dataBR);
//                    notaBean.setData(data);
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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
    
    public List<NotaFiscalBean> pesquisarPorData(String data) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal where data = ?";
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal where data = ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate _data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(_data);
//                    notaBean.setData(FormataData.UStoBR(_data));
//                    notaBean.setData(LocalDate.parse(rs.getString("data"), dataBR));
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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
    
    public List<NotaFiscalBean> pesquisarPorCanceladas(char[] cancelada) throws SQLException {
        Connection con = Conexao.abrirConexao();
        String sql = "select numero, serie, codCli, data, cancelada from notaFiscal where cancelada = ?";
//        String sql = "select numero, serie, codCli, date_format(data,'%d-%m-%Y') as data, cancelada from notaFiscal where cancelada = ?";
        ResultSet rs = null;
        List<NotaFiscalBean> listaNotas = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(cancelada));
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    NotaFiscalBean notaBean = new NotaFiscalBean();
                    notaBean.setNumero(rs.getString("numero").toCharArray());
                    notaBean.setSerie(rs.getString("serie").toCharArray());
                    notaBean.setCodCli(rs.getInt("codCli"));
                    LocalDate data = LocalDate.parse(rs.getString("data"));
                    notaBean.setData(data);
//                    notaBean.setData(FormataData.UStoBR(data));
//                    LocalDate data = LocalDate.parse(rs.getString("data"), dataBR);
//                    notaBean.setData(data);
                    notaBean.setCancelada(rs.getString("cancelada").toCharArray());
                    listaNotas.add(notaBean);
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
