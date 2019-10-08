package main.java.estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CarroDAO
 */
public class CarroDAO {
    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(CarroBean carro) throws SQLException {
        String sql = "insert into carro(placa,cor,descricao)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao inserir.";
    }

    public String alterar(CarroBean carro) throws SQLException {
        String sql = "update carro set cor = ?,descricao = ?";
        sql += " where placa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(3, carro.getPlaca());
            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao alterar.";
    }

    public String excluir(CarroBean carro) throws SQLException {
        String sql = "delete from carro where placa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Erro ao excluido.";
    }

    public List<CarroBean> listarTodos() throws SQLException {
        String sql = "select * from carro ";
        List<CarroBean> listaCarro = new ArrayList<CarroBean>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CarroBean cb = new CarroBean();
                    cb.setPlaca(rs.getString(1));
                    cb.setCor(rs.getString(2));
                    cb.setDescricao(rs.getString(3));
                    listaCarro.add(cb);
                }
                return listaCarro;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}