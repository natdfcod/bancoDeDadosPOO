package view;
import static javax.swing.JOptionPane.*;
public class MenuPrincipal {
    public static void menu() {
        String[] item = {"Usuario", "Agendamento", "Lembrete", "Metrica",  "Finalizar"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uam opção", "*** MENU PRINCIPAL ***", INFORMATION_MESSAGE, null, item, item[0]));
            switch (opcao.toLowerCase()){
                case "usuario":
                    new MenuUsuario().menu();
                    break;
                case "agendamento":
                    new MenuAgendamento().menu();
                    break;
//                case "lembrete":
//                    new MenuLembrete().menu();
//                    break;
//                case "metrica":
//                    new MenuMetrica().menu();
//                    break;
            }
        } while(!opcao.toLowerCase().equals("finalizar"));
    }
}