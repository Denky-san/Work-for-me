package com.company;

import java.util.ArrayList;

public class Universidade extends Pesquisa {
    String nome, endereco, bairro, cidade, estado;

    protected ArrayList<Cursos> cursos = new ArrayList<>();

    public Universidade(String endereco, String bairro, String cidade, String estado, ArrayList<Cursos> cursos) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cursos = cursos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
