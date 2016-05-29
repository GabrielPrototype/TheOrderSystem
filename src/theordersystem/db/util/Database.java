package theordersystem.db.util;

public class Database
{
    static private ConnectionDB con = null;
    static public boolean openConnectionDB()
    {
        if(con == null)
        {
           con = new ConnectionDB("jdbc:postgresql://localhost:5432/",
                                     "theorderdata","postgres","postgres1234");
        }
        return con.getConnectionStatus();
    }
    
    static public boolean openConnectionDB(String local,String banco,String user,String password)
    {
        if(con == null)
        {
           con = new ConnectionDB(local, banco, user, password);
        }
        return con.getConnectionStatus();
    }
    
    static public ConnectionDB getCon()
    {
        return con;
    }
}