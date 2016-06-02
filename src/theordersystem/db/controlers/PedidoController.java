/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import java.util.ArrayList;
import theordersystem.db.entities.ItemPedido;
import theordersystem.db.entities.Pedido;
import theordersystem.db.entities.Produto;
import theordersystem.db.util.Database;

/**
 *
 * @author titan
 */
public class PedidoController {
    
    public boolean save(Pedido pedido)
    {   String sql = "insert into pedidos (clienteid,data,frete) "
                     +"values ($1,'$2',$3)";
    
        sql = sql.replace("$1", "" + pedido.getClienteID());
        sql = sql.replace("$2", pedido.getData().toString());
        sql = sql.replace("$3", "" + pedido.getFrete());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean modify(Pedido pedido)
    {   String sql =    "update pedidos set clienteid = $1, data = '$2', frete = $3 "
                        + "where pedidoid = $4";
        sql = sql.replace("$1", "" + pedido.getClienteID());
        sql = sql.replace("$2", pedido.getData().toString());
        sql = sql.replace("$3", "" + pedido.getFrete());
        sql = sql.replace("$5", "" + pedido.getPedidoID());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean delete(int cod)
    {  String sql = "delete from pedidos where pedidoid = " + cod;
       return Database.getCon().manipulateSQL(sql);
    }
    
    public Pedido getPedido(int cod)
    {   Pedido pedido = null;
        ItemPedidoController IPedCtrl = new ItemPedidoController();
        ArrayList <ItemPedido> IPedidos = new ArrayList();
        String sql="select * from pedidos where produtoid = " + cod;
        
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            if(rs.next()){
                
                String sqlIPedidos = "select * from itenspedidos where pedidoid = " + cod;
                ResultSet rsIPedidos = Database.getCon().consult(sqlIPedidos);
                
                while(rsIPedidos.next()){
                    IPedidos.add(IPedCtrl.getItemPedido(rsIPedidos.getInt("itenspedidosid")));
                }
                
                pedido = new   Pedido(rs.getInt("pedidoid"),
                                    rs.getInt("clienteid"),
                                    rs.getDate("data").toLocalDate(),
                                    rs.getFloat("frete"),
                                    IPedidos
                            );
            }
        } 
        catch (Exception e){  
            System.out.println(e);
        }
        return pedido;
    }
    
    public ArrayList <Pedido> getPedidos(String filtro){
        
        ArrayList <Pedido> pedidos = new ArrayList();
        ItemPedidoController IPedCtrl = new ItemPedidoController();
        ArrayList <ItemPedido> iPedidos = new ArrayList();
        String sql = "select * from pedidos";
        
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            while(rs.next()){
                
            
                String sqlIPedidos = "select * from itenspedidos where pedidoid = " + rs.getInt("pedidoid");
                ResultSet rsIPedidos = Database.getCon().consult(sqlIPedidos);
                
                while(rsIPedidos.next()){
                    iPedidos.add(IPedCtrl.getItemPedido(rsIPedidos.getInt("itenspedidosid")));
                }
            
                pedidos.add( new    Pedido( rs.getInt("pedidoid"),
                                            rs.getInt("clienteid"),
                                            rs.getDate("data").toLocalDate(),
                                            rs.getFloat("frete"),
                                            iPedidos
                                    )
                );
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return pedidos;
    }
}
