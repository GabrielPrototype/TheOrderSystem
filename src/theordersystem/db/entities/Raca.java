package theordersystem.db.entities;

public class Raca 
{   private int cod;
    private String nome;

    public Raca() {   this(0,"");  }
    public Raca(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;    }
    public Raca(String nome) {  this(0,nome);   }
    public int getCod() { return cod;   }
    public void setCod(int cod) {  this.cod = cod;   }
    public String getNome() {  return nome; }
    public void setNome(String nome) {  this.nome = nome;  }

    @Override
    public String toString() {
        return nome;
    }
    
}
