package com.example.ProjetoAPI.model;

import jakarta.persistence.*;

@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column
    private String descricao;

    @Column
    private String marca;

    @Column
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
