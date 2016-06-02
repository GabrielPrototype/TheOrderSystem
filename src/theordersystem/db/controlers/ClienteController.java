/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.controlers;

import java.sql.ResultSet;
import java.util.ArrayList;
import theordersystem.db.entities.Cliente;
import theordersystem.db.util.Database;

/**
 *
 * @author Aluno
 */
public class ClienteController {
    
    public boolean save(Cliente cli)
    {   String sql = "insert into clientes (nome,endereco,cidade,cep,pais,email) "
                     +"values ('$1','$2','$3','$4','$5','$6')";
    
        sql=sql.replace("$1", cli.getNome());
        sql=sql.replace("$2", cli.getEndereco());
        sql=sql.replace("$3", cli.getCidade());
        sql=sql.replace("$4", cli.getCep());
        sql=sql.replace("$5", cli.getPais());
        sql=sql.replace("$6", cli.getEmail());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean modify(Cliente cli)
    {   String sql="update clientes set nome='$1', endereco='$2', cidade='$3', cep='$4',"
                    + "pais='$5',email='$6' where clienteid = $7";
        sql=sql.replace("$1", cli.getNome());
        sql=sql.replace("$2", cli.getEndereco());
        sql=sql.replace("$3", cli.getCidade());
        sql=sql.replace("$4", cli.getCep());
        sql=sql.replace("$5", cli.getPais());
        sql=sql.replace("$6", cli.getEmail());
        sql=sql.replace("$7", "" + cli.getClienteID());
        
        return Database.getCon().manipulateSQL(sql);
    }
    
    public boolean delete(Cliente cli)
    {  String sql="delete from clientes where clienteid = " + cli.getClienteID();
       return Database.getCon().manipulateSQL(sql);
    }
    
    public Cliente getCategoria(int cod)
    {   Cliente cli = null;
        
        String sql="select * from clientes where clienteid = " + cod;
        ResultSet rs = Database.getCon().consult(sql);
        try {
            if(rs.next())
               cli = new Cliente(   rs.getInt("clientedid"), 
                                    rs.getString("nome"), 
                                    rs.getString("endereco"), 
                                    rs.getString("cidade"),
                                    rs.getString("cep"),
                                    rs.getString("pais"), 
                                    rs.getString("email"));
        } 
        catch (Exception e){  
            System.out.println(e);
        }
        return cli;
    }
    
    public ArrayList <Cliente> getClientes(String filtro){
        
        ArrayList <Cliente> clientes = new ArrayList();
        String sql = "select * from clientes";
        
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs = Database.getCon().consult(sql);
        
        try {
            while(rs.next()){
               clientes.add(new Cliente(    rs.getInt("clienteid"), 
                                            rs.getString("nome"), 
                                            rs.getString("endereco"), 
                                            rs.getString("cidade"),
                                            rs.getString("cep"),
                                            rs.getString("pais"), 
                                            rs.getString("email")));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return clientes;
    }
}
