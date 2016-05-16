package theordersystem.db.util;

public class Banco
{
    static private Conexao con=null;
    static public boolean abrirConexao()
    {
        if(con==null)
        {
           con = new Conexao("","jdbc:postgresql://localhost:5433/",
                                     "fipp","postgres","postgres123");
        }
        if (!con.getEstadoConexao())
             return false;
        return true;
    }
    static public Conexao getCon()
    {
        return con;
    }
}