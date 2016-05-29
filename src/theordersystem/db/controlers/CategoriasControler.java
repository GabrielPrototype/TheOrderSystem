/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import java.util.ArrayList;
import theordersystem.db.entities.Categoria;
import theordersystem.db.util.Database;

/**
 *
 * @author titan
 */
public class CategoriasControler {
    
    public boolean save(Categoria cat)
    {   String sql = "insert into categorias (nome,descricao) "
                     +"values ('$1','$2')";
    
        sql=sql.replace("$1", cat.getNome());
        sql=sql.replace("$2", cat.getDescricao());
        
        return Database.getCon().manipulate(sql);
    }
    
    public boolean modify(Categoria cat)
    {   String sql="update categorias set nome='$1',descricao='$2' where ani_cod = $3";
        sql=sql.replace("$1", cat.getNome());
        sql=sql.replace("$2", cat.getDescricao());
        sql=sql.replace("$3", "" + cat.getCategoriaID());
        
        return Database.getCon().manipulate(sql);
    }
    
    public boolean delete(Categoria cat)
    {  String sql="delete from categorias where ani_cod = " + cat.getCategoriaID();
       return Database.getCon().manipulate(sql);
    }
    
    public Categoria getCategoria(int cod)
    {   Categoria cat = null;
        CategoriasControler CatCtrl = new CategoriasControler();
        
        String sql="select * from animal where ani_cod = "+cod;
        ResultSet rs = Database.getCon().consult(sql);
        try {
            if(rs.next())
               cat = new Categoria(rs.getInt("categoriaid"),rs.getString("nome"),rs.getString("descricao"));
        } 
        catch (Exception e){  
            System.out.println(e);
        }
        return cat;
    }
    
    public ArrayList <Categoria> getAnimais(String filtro){
        
        ArrayList <Categoria> categorias = new ArrayList();
        CtrRaca ctrr=new CtrRaca();
        String sql = "select * from categorias";
        
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            while(rs.next()){
               categorias.add(new Categoria(rs.getInt("categoriaid"),rs.getString("nome"),rs.getString("descricao")));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return categorias;
    }
}
