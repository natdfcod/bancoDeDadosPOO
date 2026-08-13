import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Categoria> listar() {
        sql = "SELECT * FROM java_categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria linha = new Categoria();
                linha.setId(rs.getInt("ID"));
                linha.setCategoria(rs.getString("categoria"));
                lista.add(linha);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
