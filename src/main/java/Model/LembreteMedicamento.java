package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LembreteMedicamento{
    private int idLembrete;
    private Usuario usuario;
    private String nomeRemedio;
    private String dosagem;
    private String horarioTomar;
    private String statusTomou;

    @Override
    public String toString() {
        return "| idLembrete=" + idLembrete +
                " | usuario=" + usuario +
                " | nomeRemedio=" + nomeRemedio +
                " | dosagem=" + dosagem +
                " | horarioTomar=" + horarioTomar +
                " | statusTomou=" + statusTomou + " |\n";
    }

    public int getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(int idLembrete) {
        this.idLembrete = idLembrete;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getHorarioTomar() {
        return horarioTomar;
    }

    public void setHorarioTomar(String horarioTomar) {
        this.horarioTomar = horarioTomar;
    }

    public String getStatusTomou() {
        return statusTomou;
    }

    public void setStatusTomou(String statusTomou) {
        this.statusTomou = statusTomou;
    }
}