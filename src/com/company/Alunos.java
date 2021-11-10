package com.company;

public class Alunos {
    protected String nome, matricula, dataNascimento, anoIngresso, situacao;

    protected Universidade universidadeDoAluno;
    protected Cursos cursoDoAluno;

    public Alunos(String nome, String matricula, String dataNascimento, String anoIngresso, String situacao,
            Universidade uni, Cursos curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.anoIngresso = anoIngresso;
        this.situacao = situacao;
        this.universidadeDoAluno = uni;
        this.cursoDoAluno = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(String anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
