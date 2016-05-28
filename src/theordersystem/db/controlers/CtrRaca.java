package theordersystem.db.controlers;

import theordersystem.db.entities.Raca;
import theordersystem.db.util.Database;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CtrRaca 
{   public boolean salvar(Raca r)
    {   String sql="insert into raca (rac_nome) values ('$1')";
        sql=sql.replace("$1", r.getNome());
        return Database.getCon().manipulate(sql);
    }
    public boolean apagar(Raca r)
    {  String sql="delete from raca where rac_cod = "+r.getCod();
       return Database.getCon().manipulate(sql);
    }
    public boolean alterar(Raca r)
    {  String sql="update raca set rac_nome = '$1' where rac_cod = $2";
       sql=sql.replace("$1", r.getNome());
       sql=sql.replace("$2", ""+r.getCod());    
       return Database.getCon().manipulate(sql);
    }
    public Raca getRaca(int cod)
    {   Raca r=null;
        String sql="select * from raca where rac_cod = "+cod;
        ResultSet rs =Database.getCon().consult(sql);
        try {
            if(rs.next())
               r=new Raca(rs.getInt("rac_cod"),rs.getString("rac_nome"));
        } catch (Exception e) {  }
        return r;
    }
    public ArrayList <Raca> getRacas(String filtro)
    {   ArrayList racas = new ArrayList();
        Raca r=null;
        String sql="select * from raca";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs =Database.getCon().consult(sql);
        try {
            while(rs.next())
            {  r=new Raca(rs.getInt("rac_cod"),rs.getString("rac_nome"));
               racas.add(r);
            }
        } catch (Exception e) {  }
        return racas;
    }
    
}
