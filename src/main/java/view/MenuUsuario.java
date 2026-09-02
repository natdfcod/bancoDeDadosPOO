package view;

import DAO.UsuarioDAO;
import Model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class MenuUsuario {
    public void menu() {
        String[] item = {"Inserir", "Listar", "Atualizar", "Deletar", "Voltar"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uma opção", "*** MENU USUARIO ***", INFORMATION_MESSAGE, null, item, item[0]));
            switch (opcao.toLowerCase()){
                case "inserir":
                    inserir();
                    break;
                case "listar":
                    listar();
                    break;
                case "atualizar":
                    atualizar();
                    break;
                case "deletar":
                    deletar();
                    break;
            }
        } while(!opcao.toLowerCase().equals("voltar"));
    }

    private void deletar() {
        List<Usuario> lista = new UsuarioDAO().listar();
        Usuario usuario = (Usuario) showInputDialog(null, "Selecione uma opção", "*** MENU USUARIO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));

        new UsuarioDAO().deletar(usuario.getIdUsuario());
    }

    private void atualizar() {
        String opcao;

        List<Usuario> lista = new UsuarioDAO().listar();
        Usuario usuario = (Usuario) showInputDialog(null, "Selecione uma opção", "*** MENU USUARIO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));

        String[] item = {"NOME", "DATA_NASCIMENTO", "NUMERO_CARTEIRINHA", "EMAIL", "SENHA"};
        opcao = (String) (showInputDialog(null, "Selecione a coluna que deseja modificar", "*** MENU ATUALIZAR USUARIO ***", INFORMATION_MESSAGE, null, item, item[0]));

        String mensagem;
        if(opcao.equals("DATA_NASCIMENTO")){

            mensagem = "DATA_NASCIMENTO (dd/mm/aaaa)";
        } else {
            mensagem = "Digite o valor que deseja inserir";
        }
        String valor = showInputDialog(mensagem);
        new UsuarioDAO().atualizar(usuario,  opcao, valor);

    }


    private void listar() {
        List<Usuario> lista = new UsuarioDAO().listar();
        String aux = "";
        for (Usuario usuario : lista){
            aux += usuario;
        }
        showMessageDialog(null, aux);

    }

    private void inserir() {
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Usuario usuario = new Usuario();
        usuario.setNome(showInputDialog("Nome"));
        usuario.setDataNascimento(LocalDate.parse(showInputDialog("DATA_NASCIMENTO (dd/mm/aaaa)"), mascara));
        usuario.setNumeroCarteirinha(parseLong(showInputDialog("NUMERO_CARTEIRINHA")));
        usuario.setEmail(showInputDialog("EMAIL"));
        usuario.setSenha(showInputDialog("SENHA"));
        new UsuarioDAO().inserir(usuario);
    }
}
