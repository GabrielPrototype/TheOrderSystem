/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author titan
 */
public class Pedido {
    
    private int pedidoID;
    private int clienteID;
    private LocalDate data;
    private float frete;
    private ArrayList <ItemPedido> itens;

    public Pedido() {
    }

    public Pedido(int clienteID, LocalDate data, float frete, ArrayList<ItemPedido> itens) {
        this(0, clienteID, data, frete, itens);
    }
    
    public Pedido(int pedidoID, int clienteID, LocalDate data, float frete, ArrayList<ItemPedido> itens) {
        this.itens = itens;
        this.pedidoID = pedidoID;
        this.clienteID = clienteID;
        this.data = data;
        this.frete = frete;
        this.itens = itens;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }
    
    
    
    
}
