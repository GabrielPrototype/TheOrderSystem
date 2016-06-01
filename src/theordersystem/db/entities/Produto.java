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
    private Categoria categoria;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(int produtoid, String nome, Categoria categoria, double preco, int estoque) {
        this.produtoID = produtoid;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, Categoria categoria, double preco, int estoque) {
        this(0, nome, categoria, preco, estoque);
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
