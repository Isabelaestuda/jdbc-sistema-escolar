package org.example.aluno;


public class Aluno {
    private int id;
    private String nomeAluno;
    private String email;
    private int idTurma;

    public Aluno(String nomeAluno, String email, int idTurma) {
        this.nomeAluno = nomeAluno;
        this.email = email;
        this.idTurma = idTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }





}
