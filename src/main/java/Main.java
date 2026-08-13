import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //teste inserindo categoria
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = new Categoria();
        categoria.setCategoria("abc");

        categoriaDAO.inserir(categoria);

        //teste listagem categoria
        List<Categoria> lista = categoriaDAO.listar();
        for (Categoria c :lista){
            System.out.printf("|ID - %d| |Categoria - %s|\n", c.getId(), c.getCategoria());
        }

        //testar despesa
        //inserir
        DespesaDAO despesaDAO = new DespesaDAO();
        Despesa despesa = new Despesa();

        despesa.setDescricao("Kenny tonto");
        despesa.setValor(1.50);
        despesa.setData(LocalDate.now());
        Categoria c = new Categoria();
        c.setId(41);
        despesa.setCategoria(c);
        despesaDAO.inserir(despesa);




    }
}
