package com.company;

import java.util.ArrayList;

public class Cursos extends Pesquisa {
    protected String nome, sigla, area;

    //ArrayList<Alunos> alunos = new ArrayList<>();
    ArrayList<Universidade> universidades = new ArrayList<>();

    public Cursos(String nome, String sigla, String area, ArrayList<Universidade> universidades) {
        this.nome = nome;
        this.sigla = sigla;
        this.area = area;
        this.universidades = universidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void inclusao() {

    }

    @Override
    public void alteracao() {

    }

    @Override
    public void consulta() {

    }

    @Override
    public void exclusao() {

    }
}
