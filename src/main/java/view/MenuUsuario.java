package view;

import DAO.UsuarioDAO;
import Model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class MenuUsuario {
    public void menu() {
        String[] item = {"Inserir", "Listar", "Sair"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uam opção", "*** MENU USUARIO ***", INFORMATION_MESSAGE, null, item, item[0]));
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
        List<Usuario> lista = new UsuarioDAO().listar();
        String aux = "";
        for (Usuario usuario : lista){
            aux += usuario;
        }
        showMessageDialog(null, aux);

    }

    private void inserir() {
        Usuario usuario = new Usuario();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        usuario.setNome(showInputDialog("Nome"));
        usuario.setDataNascimento(LocalDate.parse(showInputDialog("DATA_NASCIMENTO"), mascara));
        usuario.setNumeroCarteirinha(showInputDialog("NUMERO_CARTEIRINHA"));
        usuario.setEmail(showInputDialog("EMAIL"));
        usuario.setSenha(showInputDialog("SENHA"));
        new UsuarioDAO().inserir(usuario);
    }
}