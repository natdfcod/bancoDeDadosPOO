package DAO;

import Factory.ConnectionFactory;
import Model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements GenericDAO<Usuario, Integer> {

    DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void inserir(Usuario entidade) {
        String sql = "insert into java_usuario(nome, DATA_NASCIMENTO, NUMERO_CARTEIRINHA, EMAIL, SENHA) values(?,?,?,?,?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, entidade.getNome());
            ps.setDate(2, Date.valueOf(entidade.getDataNascimento()));
            ps.setString(3, entidade.getNumeroCarteirinha());
            ps.setString(4, entidade.getEmail());
            ps.setString(5, entidade.getSenha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Usuario: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> listar() {
        String sql = "select * from java_usuario";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setDataNascimento(rs.getDate("DATA_NASCIMENTO").toLocalDate());
                usuario.setNumeroCarteirinha(rs.getString("NUMERO_CARTEIRINHA"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Usuario" + e.getMessage());
        }
        return  listaUsuarios;
    }

    public void atualizar(Usuario usuario, String coluna, String valor) {
        String sql = "update java_usuario set " + coluna + " = ? where id_usuario = ?";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            if(coluna.equals("DATA_NASCIMENTO")) {
                ps.setDate(1, Date.valueOf(LocalDate.parse(valor, mascara)));
            } else {
                ps.setString(1, valor);
            }
            ps.setInt(2, usuario.getIdUsuario());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar usuario: " + e.getMessage());
        }

    }

}
