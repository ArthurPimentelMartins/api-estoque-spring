package com.example.projeto.estoque.web.model.entity;

public class Venda {

    private int id;
    private int id_cliente;
    private int id_produto;
    private int quantidade_comprada;


    public Venda(){}

    public Venda(int id_cliente, int id_produto, int quantidade_comprada) {
        this.id_cliente = id_cliente;
        this.id_produto = id_produto;
        this.quantidade_comprada = quantidade_comprada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade_comprada() {
        return quantidade_comprada;
    }

    public void setQuantidade_comprada(int quantidade_comprada) {
        this.quantidade_comprada = quantidade_comprada;
    }
}