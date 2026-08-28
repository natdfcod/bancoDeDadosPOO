package view;

import DAO.AgendamentoDAO;
import DAO.LembreteMedicamentoDAO;
import DAO.UsuarioDAO;
import Model.Agendamento;
import Model.LembreteMedicamento;
import Model.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

public class MenuLembrete {
    public void menu(){
        String[] item = {"Inserir", "Pesquisar", "Listar", "Atualizar", "Excluir", "Sair"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uam opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, item, item[0]));
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

    private void inserir() {
        Usuario usuario;
        LembreteMedicamento lembrete = new LembreteMedicamento();
        List<Usuario> lista = new UsuarioDAO().listar();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        usuario = (Usuario) showInputDialog(null, "Selecione uam opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));
        lembrete.setUsuario(usuario);
        lembrete.setNomeRemedio(showInputDialog(null, "NOME_REMEDIO"));
        lembrete.setTipo(showInputDialog(null, "Tipo"));
        lembrete.setMedico_especialidade(showInputDialog(null, "MEDICO_ESPECIALIDADE"));

        new LembreteMedicamentoDAO().inserir(lembrete);

    }

}
