
package theordersystem.db.entities;

public class Cliente 
{
    private int    clienteID;
    private String nome;
    private String endereco;
    private String cidade;
    private String cep;
    private String pais;
    private String email;

    public Cliente(int clienteID, String nome, String endereco, String cidade, String cep, String pais, String email) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
        this.email = email;
    }

    public Cliente() {
        this.clienteID = 0;
        this.nome = "";
        this.endereco = "";
        this.cidade = "";
        this.cep = "";
        this.pais = "";
        this.email = "";
    }

    public Cliente(String nome, String endereco, String cidade, String cep, String pais, String email) 
    {
        this(0,nome,endereco,cidade,cep,pais,email);
    }
    
    public int getClienteID(){return clienteID;}
    public void setClienteID(int clienteID){this.clienteID = clienteID;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco){this.endereco = endereco;}
    public String getCidade(){return cidade;}
    public void setCidade(String cidade){this.cidade = cidade;}
    public String getCep(){return cep;}
    public void setCep(String cep){this.cep = cep;}
    public String getPais(){return pais;}
    public void setPais(String pais){this.pais = pais;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    @Override
    public String toString() 
    {
        return  nome;
    }
    
    
}
