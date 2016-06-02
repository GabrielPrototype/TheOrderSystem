/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import theordersystem.db.entities.ItemPedido;
import theordersystem.db.util.Database;

/**
 *
 * @author titan
 */
public class ItemPedidoController {
    
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
}
