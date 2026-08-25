package view;

import DAO.VendaDAO;
import DAO.VendedorDAO;
import Model.Venda;
import Model.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class MenuVenda {
    public void menu(){
        String[] item = {"Inserir", "Pesquisar", "Listar", "Atualizar", "Excluir", "Sair"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uam opção", "*** MENU VENDA ***", INFORMATION_MESSAGE, null, item, item[0]));
            switch (opcao.toLowerCase()){
                case "inserir":
                    inserir();
                    break;
                case "listar":
                    listar();
                    break;
            }
        } while(!opcao.toLowerCase().equals("sair"));
    }

    private void listar() {
        List<Venda> lista = new VendaDAO().listar();
        String aux = "";
        for (Venda venda : lista){
            aux += "|id =  "+ venda.getId()+" | id_vendedor = "+ venda.getVendedor().getId()+" | total = "+venda.getTotal()+" | data = "+venda.getData()+"|\n";
        }
        showMessageDialog(null, aux);
    }

    private void inserir() {
        Vendedor vendedor = new Vendedor();
        List<Vendedor> lista = new VendedorDAO().listar();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        vendedor = (Vendedor) showInputDialog(null, "Selecione uam opção", "*** MENU VENDA ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));

        Double total = parseDouble(showInputDialog("Total das vendas"));
        String data = (showInputDialog("Data de venda (dd/mm/aaaa)"));
        Venda venda = new Venda();
        venda.setTotal(total);
        venda.setVendedor(vendedor);
        venda.setData(LocalDate.parse(data, mascara));
        new VendaDAO().inserir(venda);

    }
}
