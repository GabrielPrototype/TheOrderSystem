/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import java.util.ArrayList;
import theordersystem.db.entities.Produto;
import theordersystem.db.util.Database;

/**
 *
 * @author titan
 */
public class ProdutosController {
    
    public boolean save(Produto prod)
    {   String sql = "insert into produtos (nome,categoriaid,preco,estoque) "
                     +"values ('$1',$2,$3, $4)";
    
        //sql = sql.replace("$1", ""+prod.getProdutoID());
        sql = sql.replace("$1", prod.getNome());
        sql = sql.replace("$2", "" + prod.getCategoria().getCategoriaID());
        sql = sql.replace("$3", "" + prod.getPreco());
        sql = sql.replace("$4", "" + prod.getEstoque());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean modify(Produto prod)
    {   String sql =    "update produtos set nome = '$1', categoriaid = $2, preco = $3,"
                        + "estoque = $4 where produtoid = $5";
        sql = sql.replace("$1", prod.getNome());
        sql = sql.replace("$2", "" + prod.getCategoria().getCategoriaID());
        sql = sql.replace("$3", "" + prod.getPreco());
        sql = sql.replace("$4", "" + prod.getEstoque());
        sql = sql.replace("$5", "" + prod.getProdutoID());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean delete(int cod)
    {  String sql = "delete from produtos where produtoid = " + cod;
       return Database.getCon().manipulateSQL(sql);
    }
    
    public Produto getProduto(int cod)
    {   Produto prod = null;
        CategoriasController CatCtrl = new CategoriasController();
        
        String sql="select * from produtos where produtoid = " + cod;
        ResultSet rs = Database.getCon().consult(sql);
        try {
            if(rs.next()){
               prod = new   Produto(  rs.getInt("produtoid"),
                                    rs.getString("nome"),
                                    CatCtrl.getCategoria(rs.getInt("categoriaid")),
                                    rs.getDouble("preco"),
                                    rs.getInt("estoque")
                            );
            }
        } 
        catch (Exception e){  
            System.out.println(e);
        }
        return prod;
    }
    
    public ArrayList <Produto> getProdutos(String filtro){
        
        ArrayList <Produto> categorias = new ArrayList();
        CategoriasController CatCtrl = new CategoriasController();
        String sql = "select * from produtos";
        
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            while(rs.next()){
                categorias.add( new Produto(  rs.getInt("produtoid"),
                                    rs.getString("nome"),
                                    CatCtrl.getCategoria(rs.getInt("categoriaid")),
                                    rs.getDouble("preco"),
                                    rs.getInt("estoque")
                                )
                );
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return categorias;
    }
}
