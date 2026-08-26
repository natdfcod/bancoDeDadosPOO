package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LembreteMedicamento{
    private int idLembrete;
    private Usuario usuario;
    private String nomeRemedio;
    private String dosagem;
    private LocalDateTime horarioTomar;
    private String statusTomou;

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

    public LocalDateTime getHorarioTomar() {
        return horarioTomar;
    }

    public void setHorarioTomar(LocalDateTime horarioTomar) {
        this.horarioTomar = horarioTomar;
    }

    public String getStatusTomou() {
        return statusTomou;
    }

    public void setStatusTomou(String statusTomou) {
        this.statusTomou = statusTomou;
    }
}