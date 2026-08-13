import java.sql.*;

public class DespesaDAO {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public DespesaDAO() {
        this.connection = new Conexao().conectar();
    }

    public void inserir(Despesa despesa){
        sql = "insert into java_despesa(descricao, valor, data, id_categoria) values(?, ?, ?, ?)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getData()));
            ps.setInt(4, despesa.getCategoria().getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
