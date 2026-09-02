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
        List<Agendamento> lista = new AgendamentoDAO().listar();
        String aux = "";
        for (Agendamento agendamento : lista){
            aux += agendamento;
        }
        showMessageDialog(null, aux);
    }

    private void inserir() {
        Agendamento agendamento = new Agendamento();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String[] tipos = {"Consulta", "Exame"};

        //Pegando e pedindo usuario para relacionar com o agendamento
        List<Usuario> lista = new UsuarioDAO().listar();
        Usuario usuario = (Usuario) showInputDialog(null, "Selecione uma opção", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));
        agendamento.setUsuario(usuario);

        //Pedindo os dados do agendamento
        agendamento.setDataHoraAgendada(LocalDateTime.parse(showInputDialog(null, "Data e hora agendada (dd/mm/aaaa hh:mm)"), mascara));
        //Deixando o tipo para selecionar
        agendamento.setTipo((String) showInputDialog(null, "Selecione o tipo do agendamento", "*** MENU AGENDAMENTO ***", INFORMATION_MESSAGE, null, tipos, tipos[0]));
        agendamento.setMedico_especialidade(showInputDialog(null, "MEDICO_ESPECIALIDADE"));

        new AgendamentoDAO().inserir(agendamento);

    }
}