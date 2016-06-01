package theordersystem.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static theordersystem.TheOrderSystem.databaseConfigs;

public class ConnectionDB
{   
    private Connection connect;
    private String error = "";
    
    /**
     *
     * @param local
     * @param database
     * @param user
     * @param password
     */
    
    public ConnectionDB(String local, String database, String user, String password){   
        
        try {
            //Class.forName(driver); //"org.postgresql.Driver");
            String url = local+database; //"jdbc:postgresql://localhost/"+banco;
            connect = DriverManager.getConnection(url, user,password);
        }
        //catch ( ClassNotFoundException cnfex )
        //{ erro="Falha ao ler o driver JDBC: " + cnfex.toString(); }
        catch ( SQLException sqlex )
        { error = "Unable to connect Database: " + sqlex.toString(); }
        catch ( Exception ex )
        { error = "Other Error: " + ex.toString(); }
    }
    
    public ConnectionDB(){
        this(   databaseConfigs.getLocal(),databaseConfigs.getDatabase(),
                databaseConfigs.getUser(), databaseConfigs.getPassword());
    }
    
    /**
     *
     * @return error message string
     */
    public String getErrorMessage() {
        return error;
    }
    
    public boolean getConnectionStatus() {
        if(connect == null)  return false;
        else return true;
    }
    
    public boolean manipulateSQL(String sql){ // inserir, alterar,excluir
        try {
            Statement statement = connect.createStatement();
            int result = statement.executeUpdate( sql );
            statement.close();
            if(result>=1)
                return true;
        }
        catch ( SQLException sqlex )
        {  error="Erro: "+sqlex.toString();
           return false;
        }
        return false;
    }
    
    public ResultSet consult(String sql){   
        ResultSet rs=null;
        try {
           Statement statement = connect.createStatement();
             //ResultSet.TYPE_SCROLL_INSENSITIVE,
             //ResultSet.CONCUR_READ_ONLY);
           rs = statement.executeQuery( sql );
           //statement.close();
        }
        catch ( SQLException sqlex )
        { error="Erro: "+sqlex.toString();
          return null;
        }
        return rs;
    }
    
    public int getMaxPK(String tabela,String chave){
        
        String sql="select max("+chave+") from "+tabela;
        int max=0;
        ResultSet rs= consult(sql);
        try 
        {
            if(rs.next())
                max=rs.getInt(1);
        }
        catch (SQLException sqlex)
        { 
             error="Erro: " + sqlex.toString();
             return -1;
        }
        return max;
    }
}