package DAO;

import Factory.ConnectionFactory;
import Model.MetricaSaude;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetricaSaudeDAO implements GenericDAO<MetricaSaude, Integer> {

    @Override
    public void inserir(MetricaSaude entidade) {
        String sql = "insert into java_METRICA_SAUDE(ID_USUARIO, BATIMENTOS_BPM, PRESSAO_SISTOLICA, PRESSAO_DIASTOLICA, QTD_PASSOS, CALORIAS_GASTAS, DATA_HORA_REGISTRO) values(?,?,?,?,?,?,?)";

        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, entidade.getUsuario().getIdUsuario());
            ps.setInt(2, entidade.getBatimentosBpm());
            ps.setInt(3, entidade.getPressaoSistolica());
            ps.setInt(4, entidade.getPressaoDiastolica());
            ps.setInt(5, entidade.getQtdPassos());
            ps.setDouble(6, entidade.getCaloriasGastas());
            ps.setTimestamp(7, Timestamp.valueOf(entidade.getDataHoraRegistro()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir metrica: " + e.getMessage());
        }
    }

    @Override
    public List<MetricaSaude> listar() {
        String sql = "select * from java_METRICA_SAUDE";
        List<MetricaSaude> listaMetrica = new ArrayList<>();
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MetricaSaude metrica = new MetricaSaude();
                Usuario usuario = new Usuario();
                metrica.setIdMetrica(rs.getInt("ID_METRICA"));
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                metrica.setUsuario(usuario);
                metrica.setBatimentosBpm(rs.getInt("BATIMENTOS_BPM"));
                metrica.setPressaoSistolica(rs.getInt("PRESSAO_SISTOLICA"));
                metrica.setPressaoDiastolica(rs.getInt("PRESSAO_DIASTOLICA"));
                metrica.setQtdPassos(rs.getInt("QTD_PASSOS"));
                metrica.setCaloriasGastas(rs.getDouble("CALORIAS_GASTAS"));
                metrica.setDataHoraRegistro(rs.getTimestamp("DATA_HORA_REGISTRO").toLocalDateTime());
                listaMetrica.add(metrica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar metrica" + e.getMessage());
        }
        return listaMetrica;
    }
}
