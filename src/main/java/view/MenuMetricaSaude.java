package view;

import DAO.LembreteMedicamentoDAO;
import DAO.MetricaSaudeDAO;
import DAO.UsuarioDAO;
import Model.LembreteMedicamento;
import Model.MetricaSaude;
import Model.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class MenuMetricaSaude {
    public void menu(){
        String[] item = {"Inserir", "Listar", "Voltar"};
        String opcao;
        do {
            opcao = (String) (showInputDialog(null, "Selecione uma opção", "*** MENU METRICA SAÚDE ***", INFORMATION_MESSAGE, null, item, item[0]));
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
        List<MetricaSaude> lista = new MetricaSaudeDAO().listar();
        String aux = "";
        for (MetricaSaude metricaSaude : lista){
            aux += metricaSaude;
        }
        showMessageDialog(null, aux);
    }

    private void inserir() {
        MetricaSaude metricaSaude = new MetricaSaude();

        //Pegando e pedindo usuario para relacionar com a metrica
        List<Usuario> lista = new UsuarioDAO().listar();
        Usuario usuario = (Usuario) showInputDialog(null, "Selecione uam opção", "*** MENU METRICA SAÚDE ***", INFORMATION_MESSAGE, null, lista.toArray(), lista.get(0));
        metricaSaude.setUsuario(usuario);

        //Pedindo os dados da metrica
        metricaSaude.setBatimentosBpm(parseInt(showInputDialog(null, "BATIMENTOS_BPM")));
        metricaSaude.setPressaoSistolica(parseInt(showInputDialog(null, "DOSAGEM")));
        metricaSaude.setPressaoDiastolica(parseInt(showInputDialog(null, "PRESSAO_DIASTOLICA")));
        metricaSaude.setQtdPassos(parseInt(showInputDialog(null, "QTD_PASSOS")));
        metricaSaude.setCaloriasGastas(parseDouble(showInputDialog(null, "CALORIAS_GASTAS")));

        //Colocando a data e hora do registro automaticamente
        metricaSaude.setDataHoraRegistro(LocalDateTime.now());

        new MetricaSaudeDAO().inserir(metricaSaude);

    }

}
