package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class LembreteMedicamento{
    private int idLembrete;
    private int idUsuario;
    private String nomeRemedio;
    private String dosagem;
    private LocalTime horarioTomar;
    private char statusTomou;

    public int getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(int idLembrete) {
        this.idLembrete = idLembrete;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public LocalTime getHorarioTomar() {
        return horarioTomar;
    }

    public void setHorarioTomar(LocalTime horarioTomar) {
        this.horarioTomar = horarioTomar;
    }

    public char getStatusTomou() {
        return statusTomou;
    }

    public void setStatusTomou(char statusTomou) {
        this.statusTomou = statusTomou;
    }
}