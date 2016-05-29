/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.entities;

/**
 *
 * @author titan
 */
public class Produto {
    
    private int produtoID;
    private String nome;
    private int categoriaid;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(int produtoid, String nome, int categoriaid, double preco, int estoque) {
        this.produtoID = produtoid;
        this.nome = nome;
        this.categoriaid = categoriaid;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, int categoriaid, double preco, int estoque) {
        this(0, nome, categoriaid, preco, estoque);
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    
    
}
