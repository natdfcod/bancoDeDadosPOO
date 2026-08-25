package DAO;

import Factory.ConnectionFactory;
import Model.Venda;
import Model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ps.setDate(3, entidade.getData());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Vendedor: " + e.getMessage());
        }
    }

    @Override
    public List<Vendedor> listar() {
        String sql = "select * from java_vendedor";
        List<Vendedor> listaVendedor = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                listaVendedor.add(vendedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Vendedor" + e.getMessage());
        }
        return  listaVendedor;
    }
}
