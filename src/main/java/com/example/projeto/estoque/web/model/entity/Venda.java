package com.example.projeto.estoque.web.model.entity;

import jakarta.persistence.*;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Long quantidadeComprada;


    public Venda(){}

    public Venda(Cliente cliente, Produto produto, Long quantidadeComprada) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(Long quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }
}