import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public CategoriaDAO() {
        this.connection = new Conexao().conectar();
    }
    public void inserir(Categoria categoria){
        sql = "insert into java_categoria(categoria) values(?)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.execute();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void listar() {
        sql = "SELECT * FROM java_categoria";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.printf("ID: %d | Categoria: %s \n",rs.getInt("ID"), rs.getString("categoria"));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
