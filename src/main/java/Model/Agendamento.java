package Model;

import java.time.LocalDateTime;

public class Agendamento{
    private int id_agendamento;
    private Usuario usuario;
    private String tipo;
    private String medicoEspecialidade;
    private LocalDateTime dataHoraAgendada;

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedicoEspecialidade() {
        return medicoEspecialidade;
    }

    public void setMedico_especialidade(String medicoEspecialidade) {
        this.medicoEspecialidade = medicoEspecialidade;
    }

    public LocalDateTime getDataHoraAgendada() {
        return dataHoraAgendada;
    }

    public void setDataHoraAgendada(LocalDateTime dataHoraAgendada) {
        this.dataHoraAgendada = dataHoraAgendada;
    }
}