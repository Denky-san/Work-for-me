package com.company;

import java.util.ArrayList;

public class Cursos extends Pesquisa {

    protected String nome, sigla, area;
    protected Universidade universidade;

    public Cursos(String nome, String sigla, String area, Universidade universidades) {
        this.nome = nome;
        this.sigla = sigla;
        this.area = area;
        this.universidade = universidades;
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

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
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
