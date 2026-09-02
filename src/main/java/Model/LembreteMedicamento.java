package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LembreteMedicamento{
    private Integer idLembrete;
    private Usuario usuario;
    private String nomeRemedio;
    private String dosagem;
    private String horarioTomar;
    private char statusTomou;

    @Override
    public String toString() {
        return "| idLembrete: " + idLembrete +
                " | id_usuario: " + usuario.getIdUsuario() +
                " | nomeRemedio: " + nomeRemedio +
                " | dosagem: " + dosagem +
                " | horarioTomar: " + horarioTomar +
                " | statusTomou: " + statusTomou + " |\n";
    }

    public Integer getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(Integer idLembrete) {
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

    public char getStatusTomou() {
        return statusTomou;
    }

    public void setStatusTomou(char statusTomou) {
        this.statusTomou = statusTomou;
    }
}