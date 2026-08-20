package DAO;

import Factory.ConnectionFactory;
import Model.Agendamento;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO implements GenericDAO<Agendamento, Integer> {

    @Override
    public void inserir(Agendamento entidade) {
        String sql = "insert into java_agendamento(id_usuario, tipo, medico_especialidade, data_hora_agendada) values(?, ?, ?, ?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, entidade.getId_usuario());
            ps.setString(2, entidade.getTipo());
            ps.setString(3, entidade.getMedicoEspecialidade());
            ps.setTimestamp(4, Timestamp.valueOf(entidade.getDataHoraAgendada()));

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Agendamento: " + e.getMessage());
        }
    }

    @Override
    public List<Agendamento> listar() {
        String sql = "select * from java_agendamento";
        List<Agendamento> listaAgendamento = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Agendamento linha = new Agendamento();
                linha.setId_usuario(rs.getInt("id_usuario"));
                linha.setTipo(rs.getString("tipo"));
                linha.setMedico_especialidade(rs.getString("medico_especialidade"));
                linha.setDataHoraAgendada(rs.getTimestamp("data_hora_agendada").toLocalDateTime());
                listaAgendamento.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar agendamento" + e.getMessage());
        }
        return listaAgendamento;
    }
}
