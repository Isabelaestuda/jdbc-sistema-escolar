package org.example.turma;

public class Turma {

    private int id;
    private String nomeTurma;
    private String periodo;


    public Turma(String nomeTurma, String periodo) {
        this.nomeTurma = nomeTurma;
        this.periodo = periodo;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNomeTurma() {
        return nomeTurma;
    }


    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }


    public String getPeriodo() {
        return periodo;
    }


    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
