package Model;

import java.time.LocalDateTime;

public class MetricaSaude{
    private int idMetrica;
    private int idUsuario;
    private int batimentosBpm;
    private int pressaoSistolica;
    private int pressaoDiastolica;
    private int qtdPassos;
    private double caloriasGastas;
    private LocalDateTime dataHoraRegistro;

    public int getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(int idMetrica) {
        this.idMetrica = idMetrica;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getBatimentosBpm() {
        return batimentosBpm;
    }

    public void setBatimentosBpm(int batimentosBpm) {
        this.batimentosBpm = batimentosBpm;
    }

    public int getPressaoSistolica() {
        return pressaoSistolica;
    }

    public void setPressaoSistolica(int pressaoSistolica) {
        this.pressaoSistolica = pressaoSistolica;
    }

    public int getPressaoDiastolica() {
        return pressaoDiastolica;
    }

    public void setPressaoDiastolica(int pressaoDiastolica) {
        this.pressaoDiastolica = pressaoDiastolica;
    }

    public int getQtdPassos() {
        return qtdPassos;
    }

    public void setQtdPassos(int qtdPassos) {
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
}