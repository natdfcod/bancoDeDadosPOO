package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetricaSaude{
    private Integer idMetrica;
    private Usuario usuario;
    private Integer batimentosBpm;
    private Integer pressaoSistolica;
    private Integer pressaoDiastolica;
    private Integer qtdPassos;
    private double caloriasGastas;
    private LocalDateTime dataHoraRegistro;


    @Override
    public String toString() {
    DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "| idMetrica: " + idMetrica +
                " | id_usuario: " + usuario.getIdUsuario() +
                " | batimentosBpm: " + batimentosBpm +
                " | pressaoSistolica: " + pressaoSistolica +
                " | pressaoDiastolica: " + pressaoDiastolica +
                " | qtdPassos: " + qtdPassos +
                " | caloriasGastas: " + caloriasGastas +
                " | dataHoraRegistro: " + dataHoraRegistro.format(mascara) + " |\n";
    }

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Integer getBatimentosBpm() {
        return batimentosBpm;
    }

    public void setBatimentosBpm(Integer batimentosBpm) {
        this.batimentosBpm = batimentosBpm;
    }

    public Integer getPressaoSistolica() {
        return pressaoSistolica;
    }

    public void setPressaoSistolica(Integer pressaoSistolica) {
        this.pressaoSistolica = pressaoSistolica;
    }

    public Integer getPressaoDiastolica() {
        return pressaoDiastolica;
    }

    public void setPressaoDiastolica(Integer pressaoDiastolica) {
        this.pressaoDiastolica = pressaoDiastolica;
    }

    public Integer getQtdPassos() {
        return qtdPassos;
    }

    public void setQtdPassos(Integer qtdPassos) {
        this.qtdPassos = qtdPassos;
    }

    public double getCaloriasGastas() {
        return caloriasGastas;
    }

    public void setCaloriasGastas(double caloriasGastas) {
        this.caloriasGastas = caloriasGastas;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}