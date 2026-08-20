package DAO;

import Factory.ConnectionFactory;
import Model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements GenericDAO<Vendedor, Integer> {

    @Override
    public void inserir(Vendedor entidade) {
        String sql = "insert into java_vendedor(nome) values(?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, entidade.getNome());
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
