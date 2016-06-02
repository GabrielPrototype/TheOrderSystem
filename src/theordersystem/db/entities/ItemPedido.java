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
public class ItemPedido {
    private int itensPedidosID;
    private int pedidoID;
    private Produto produto;
    private float preco;
    private int quantidade;
    

    public ItemPedido() {
        this.itensPedidosID = 0;
        this.pedidoID = 0;
        this.produto = null;
        this.preco = 0;
        this.quantidade = 0;
    }

    public ItemPedido(int pedidoID, Produto produto, float preco, int quantidade) {
        this(0, pedidoID, produto, preco, quantidade);
    }
    
    
    
    public ItemPedido(int itensPedidosID, int pedidoID, Produto produto, float preco, int quantidade) {
        this.itensPedidosID = itensPedidosID;
        this.pedidoID = pedidoID;
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getItensPedidosID() {
        return itensPedidosID;
    }

    public void setItensPedidosID(int itensPedidosID) {
        this.itensPedidosID = itensPedidosID;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
