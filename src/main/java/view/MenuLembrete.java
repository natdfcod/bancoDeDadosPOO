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

import static javax.swing.JOptionPane.*;

public class MenuLembrete {
    public void menu(){
        String[] item = {"Inserir", "Listar", "Voltar"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uma opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, item, item[0]));
            switch (opcao.toLowerCase()){
                case "inserir":
                    inserir();
                    break;
                case "listar":
                    listar();
                    break;
            }
        } while(!opcao.toLowerCase().equals("voltar"));
    }

    private void listar() {
        List<LembreteMedicamento> lista = new LembreteMedicamentoDAO().listar();
        String aux = "";
        for (LembreteMedicamento lembrete : lista){
            aux += lembrete;
        }
        showMessageDialog(null, aux);
    }

    private void inserir() {
        LembreteMedicamento lembrete = new LembreteMedicamento();

        //Pegando e pedindo usuario para relacionar com o lembrete
        List<Usuario> lista = new UsuarioDAO().listar();
        Usuario usuario = (Usuario) showInputDialog(null, "Selecione uam opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));
        lembrete.setUsuario(usuario);

        //Pedindo os dados do lembrete
        lembrete.setNomeRemedio(showInputDialog(null, "NOME_REMEDIO"));
        lembrete.setDosagem(showInputDialog(null, "DOSAGEM"));
        lembrete.setHorarioTomar(showInputDialog(null, "HORARIO_TOMAR"));
        lembrete.setDosagem(showInputDialog(null, "STATUS_TOMOU(S/N)"));

        new LembreteMedicamentoDAO().inserir(lembrete);

    }

}
