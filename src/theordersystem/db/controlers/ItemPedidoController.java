/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import java.util.ArrayList;
import theordersystem.db.entities.ItemPedido;
import theordersystem.db.util.Database;

/**
 *
 * @author titan
 */
public class ItemPedidoController {
    
    public boolean save(ItemPedido iPedido)
    {   String sql = "insert into itenspedidos (pedidoid,produtoid,preco,quantidade) "
                     +"values ($1,$2,$3, $4)";
    
        sql = sql.replace("$1", "" + iPedido.getPedidoID());
        sql = sql.replace("$2", "" + iPedido.getProduto().getProdutoID());
        sql = sql.replace("$3", "" + iPedido.getPreco());
        sql = sql.replace("$4", "" + iPedido.getQuantidade());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean modify(ItemPedido iPedido)
    {   String sql =    "update itenspedidos set pedidoid = $1, produtoid = $2, preco = $3,"
                        + "quantidade = $4 where itenspedidosid = $5";
        sql = sql.replace("$1", "" + iPedido.getPedidoID());
        sql = sql.replace("$2", "" + iPedido.getProduto().getProdutoID());
        sql = sql.replace("$3", "" + iPedido.getPreco());
        sql = sql.replace("$4", "" + iPedido.getQuantidade());
        sql = sql.replace("$5", "" + iPedido.getItensPedidosID());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean delete(int cod)
    {  String sql = "delete from itenspedidos where itenspedidosid = " + cod;
       return Database.getCon().manipulateSQL(sql);
    }
    
    public ItemPedido getItemPedido(int cod)
    {   ItemPedido iPedido = null;
        ProdutosController prodCtrl = new ProdutosController();
        
        String sql="select * from itenspedidos where itenspedidosid = " + cod;
        ResultSet rs = Database.getCon().consult(sql);
        try {
            if(rs.next()){
                iPedido = new   ItemPedido(rs.getInt("itenspedidosid"),
                                        rs.getInt("pedidoid"),
                                        prodCtrl.getProduto(rs.getInt("produtoid")),
                                        rs.getFloat("preco"),
                                        rs.getInt("quantidade")
                                );
            }
        } 
        catch (Exception e){  
            System.out.println(e);
        }
        return iPedido;
    }
    
    public ArrayList <ItemPedido> getItemPedidos(String filtro){
        
        ArrayList <ItemPedido> iPedidos = new ArrayList();
        ProdutosController prodCtrl = new ProdutosController();
        String sql = "select * from itenspedidos";
        
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            while(rs.next()){
                iPedidos.add( new   ItemPedido( rs.getInt("itenspedidosid"), 
                                                rs.getInt("pedidoid"), 
                                                prodCtrl.getProduto(rs.getInt("produtoid")),
                                                rs.getFloat("preco"),
                                                rs.getInt("quantidade")
                                    )
                );
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return iPedidos;
    }
}    
