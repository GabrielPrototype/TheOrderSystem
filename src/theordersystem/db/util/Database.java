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
    
    static public boolean openConnectionDB(String local, String database, String user, String password)
    {
        if(con == null)
        {
           con = new ConnectionDB(local, database, user, password);
        }
        return con.getConnectionStatus();
    }
    
    static public ConnectionDB getCon()
    {
        return con;
    }
}

