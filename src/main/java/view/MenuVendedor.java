package view;

import DAO.VendedorDAO;
import Model.Vendedor;

import java.util.List;

import static javax.swing.JOptionPane.*;

public class MenuVendedor {
    public void menu() {
        String[] item = {"Inserir", "Pesquisar", "Listar", "Atualizar", "Excluir", "Sair"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uam opção", "*** MENU VENDEDOR ***", INFORMATION_MESSAGE, null, item, item[0]));
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
        List<Vendedor> lista = new VendedorDAO().listar();
        String aux = "";
        for (Vendedor vendedor : lista){
            aux += "|id =  "+vendedor.getId()+" | nome = "+vendedor.getNome()+"|\n";
        }
        showMessageDialog(null, aux);

    }

    private void inserir() {
        Vendedor vendedor = new Vendedor();
        String nome = showInputDialog("Nome");
        vendedor.setNome(nome);
        new VendedorDAO().inserir(vendedor);
    }
}
