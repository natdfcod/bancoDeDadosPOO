import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
//        teste de conexão
//        System.out.println(connection);

        String sql;
        PreparedStatement ps;

        sql = "insert into java_categoria(categoria) values(?)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, "salada");
            ps.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }


    }
}
