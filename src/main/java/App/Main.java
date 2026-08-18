package App;

import DAO.VendedorDAO;
import Model.Vendedor;

public class Main {

    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor();
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedor.setNome("aaa");
        vendedorDAO.inserir(vendedor);

    }
}
