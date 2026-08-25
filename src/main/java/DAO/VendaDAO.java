package DAO;

import Factory.ConnectionFactory;
import Model.Venda;
import Model.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO implements GenericDAO<Venda, Integer> {

    @Override
    public void inserir(Venda entidade) {
        String sql = "insert into java_venda(id_vendedor, total, data) values(?,?,?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, entidade.getVendedor().getId());
            ps.setDouble(2, entidade.getTotal());
            ps.setDate(3, Date.valueOf(entidade.getData()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Vendedor: " + e.getMessage());
        }
    }

    @Override
    public List<Venda> listar() {
        String sql = "select * from java_venda";
        List<Venda> listaVenda = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Venda venda = new Venda();
                Vendedor vendedor = new Vendedor();

                venda.setId(rs.getInt("id"));
                vendedor.setId(rs.getInt("id_vendedor"));
                venda.setTotal(rs.getDouble("total"));
                venda.setData(rs.getDate("data").toLocalDate());

                venda.setVendedor(vendedor);
                listaVenda.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Vendedor" + e.getMessage());
        }
        return listaVenda;
    }
}
