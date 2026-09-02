package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario{

    private Integer idUsuario;
    private String nome;
    private LocalDate dataNascimento;
    private Long numeroCarteirinha;
    private String email;
    private String senha;


    @Override
    public String toString() {
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "| idUsuario: " + idUsuario +
                " | nome: " + nome +
                " | dataNascimento: " + dataNascimento.format(mascara) +
                " | numeroCarteirinha: " + numeroCarteirinha +
                " | email: " + email +
                " | senha: " + senha + " |\n";
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(Long numeroCarteirinha) {
        this.numeroCarteirinha = numeroCarteirinha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}