import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
      CategoriaDAO categoriaDAO = new CategoriaDAO();
      Categoria categoria = new Categoria();
      categoria.setCategoria("aaa");
      categoriaDAO.inserir(categoria);

      categoriaDAO.listar();
    }
}
