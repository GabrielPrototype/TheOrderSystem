/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author titan
 */
public class DatabaseConfigs {
    
    private String local;
    private String database;
    private String user;
    private String password;

    public DatabaseConfigs() {
        this.local = "";
        this.database = "";
        this.user = "";
        this.password = "";
    }
    
    
    public DatabaseConfigs(String local, String database, String user, String password) {
        this.local = local;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
        public void writeConfigs(){
        this.writeConfigs("/Files/conf/DefaultConfigs.ordersys");
    }
    
    public void writeConfigs(String path){
        
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();           
        } catch (Exception e) 
        {
            System.out.println(e);
        } 
    };
    
    public static DatabaseConfigs loadConfigs(){
        return DatabaseConfigs.loadConfigs("/Files/conf/DefaultConfigs.ordersys");
    }
    
    public static DatabaseConfigs loadConfigs(String path){
        
        DatabaseConfigs aux=null;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            aux=(DatabaseConfigs)ois.readObject();
            ois.close();
        
        } 
        catch (IOException | ClassNotFoundException e) {
            
        }
        return aux;
    };
}