package DAO;

import Factory.ConnectionFactory;
import Model.Agendamento;
import Model.LembreteMedicamento;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LembreteMedicamentoDAO implements GenericDAO<LembreteMedicamento, Integer> {

    @Override
    public void inserir(LembreteMedicamento entidade) {
        String sql = "insert into java_lembrete_medicamento(ID_USUARIO, NOME_REMEDIO, DOSAGEM, HORARIO_TOMAR, STATUS_TOMOU) values(?,?,?,?,?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, entidade.getUsuario().getIdUsuario());
            ps.setString(2, entidade.getNomeRemedio());
            ps.setString(3, entidade.getDosagem());
            ps.setString(4, entidade.getDosagem());
            ps.setString(5, String.valueOf(entidade.getStatusTomou()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir lembrete: " + e.getMessage());
        }
    }

    @Override
    public List<LembreteMedicamento> listar() {
        String sql = "select * from java_LEMBRETE_MEDICAMENTO";
        List<LembreteMedicamento> listaLembrete = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LembreteMedicamento lembreteMedicamento = new LembreteMedicamento();
                Usuario usuario = new Usuario();
                lembreteMedicamento.setIdLembrete(rs.getInt("ID_LEMBRETE"));
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                lembreteMedicamento.setUsuario(usuario);
                lembreteMedicamento.setNomeRemedio(rs.getString("NOME_REMEDIO"));
                lembreteMedicamento.setDosagem(rs.getString("DOSAGEM"));
                lembreteMedicamento.setHorarioTomar(rs.getString("HORARIO_TOMAR"));
                lembreteMedicamento.setStatusTomou(rs.getString("STATUS_TOMOU").charAt(0));
                listaLembrete.add(lembreteMedicamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar de lembretes" + e.getMessage());
        }
        return  listaLembrete;
    }
}
