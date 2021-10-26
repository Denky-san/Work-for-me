package com.company;

public abstract class Pesquisa
{
    private static int id = 1;

    public int adicionaID(){
        int ID = this.getId();
        this.setId(this.getId()+1);
        return ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        Pesquisa.id = id;
    }

    public abstract void inclusao();

    public abstract void alteracao();

    public abstract void consulta();

    public abstract void exclusao();
}
