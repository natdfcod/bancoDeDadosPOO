package view;

import DAO.AgendamentoDAO;
import DAO.UsuarioDAO;
import Model.Agendamento;
import Model.Usuario;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class MenuAgendamento {
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

    private void listar() {
        List<Agendamento> lista = new AgendamentoDAO().listar();
        String aux = "";
        for (Agendamento agendamento : lista){
            aux += agendamento;
        }
        showMessageDialog(null, aux);
    }

    private void inserir() {
        Agendamento agendamento = new Agendamento();
        Usuario usuario = new Usuario();
        List<Usuario> lista = new UsuarioDAO().listar();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        usuario = (Usuario) showInputDialog(null, "Selecione uam opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));
        agendamento.setUsuario(usuario);
        agendamento.setDataHoraAgendada(LocalDateTime.parse(showInputDialog(null, "Data e hora agendada (dd/mm/aaaa-hh:mm)"), mascara));
        agendamento.setTipo(showInputDialog(null, "Tipo"));
        agendamento.setMedico_especialidade(showInputDialog(null, "MEDICO_ESPECIALIDADE"));

        new AgendamentoDAO().inserir(agendamento);

    }
}