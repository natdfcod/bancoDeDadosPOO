package Model;

import java.time.LocalDate;

public class Usuario{
    private int idUsuario;
    private String nome;
    private LocalDate dataNascimento;
    private String numeroCarteirinha;
    private String email;
    private String senha;


    @Override
    public String toString() {
        return
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", numeroCarteirinha='" + numeroCarteirinha + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\n' ;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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

    public String getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(String numeroCarteirinha) {
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