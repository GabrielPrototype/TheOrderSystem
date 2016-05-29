package theordersystem.db.controlers;

import theordersystem.db.entities.Animal;
import theordersystem.db.util.Database;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CtrAnimal 
{   
    public boolean salvar(Animal a)
    {   String sql="insert into animal (ani_nome,ani_peso,ani_dtnasc,rac_cod) "
            +       "values ('$1',$2,'$3',$4)";
        sql=sql.replace("$1", a.getNome());
        sql=sql.replace("$2", ""+a.getPeso());
        sql=sql.replace("$3", a.getDtnasc().toString());
        sql=sql.replace("$4", ""+a.getRaca().getCod());
        
        return Database.getCon().manipulateSQL(sql);
    }
    public boolean alterar(Animal a)
    {   String sql="update animal set ani_nome='$1',ani_peso=$2,ani_dtnasc='$3',"
                  + "rac_cod=$4 where ani_cod = $5";
        sql=sql.replace("$1", a.getNome());
        sql=sql.replace("$2", ""+a.getPeso());
        sql=sql.replace("$3", a.getDtnasc().toString());
        sql=sql.replace("$4", ""+a.getRaca().getCod());
        sql=sql.replace("$5", ""+a.getCod());
        
        return Database.getCon().manipulateSQL(sql);
    }
    public boolean apagar(Animal a)
    {  String sql="delete from animal where ani_cod = "+a.getCod();
       return Database.getCon().manipulateSQL(sql);
    }
    public Animal getAnimal(int cod)
    {   Animal a=null;
        CtrRaca ctrr=new CtrRaca();
        String sql="select * from animal where ani_cod = "+cod;
        ResultSet rs =Database.getCon().consult(sql);
        try {
            if(rs.next())
               a=new Animal(rs.getInt("ani_cod"),
                            rs.getString("ani_nome"),
                            rs.getDouble("ani_peso"),
                            rs.getDate("ani_dtnasc").toLocalDate(),
                            ctrr.getRaca(rs.getInt("rac_cod")));
        } catch (Exception e) {  }
        return a;
    }
    public ArrayList <Animal> getAnimais(String filtro)
    {   ArrayList <Animal> animais=new ArrayList();
        CtrRaca ctrr=new CtrRaca();
        String sql="select * from animal";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs =Database.getCon().consult(sql);
        try {
            while(rs.next())
               animais.add(new Animal(rs.getInt("ani_cod"),
                            rs.getString("ani_nome"),
                            rs.getDouble("ani_peso"),
                            rs.getDate("ani_dtnasc").toLocalDate(),
                            ctrr.getRaca(rs.getInt("rac_cod"))));
        } catch (Exception e) {  }
        return animais;
    }
    
}
