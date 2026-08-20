package Model;

import java.time.LocalDateTime;

public class Agendamento{
    private int id_agendamento;
    private int id_usuario;
    private String tipo;
    private String medicoEspecialidade;
    private LocalDateTime dataHoraAgendada;

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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