/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theordersystem.db.entities;

/**
 *
 * @author titan
 */
public class Categoria {
    
    private int categoriaID;
    private String nome;
    private String descricao;

    public Categoria() {
    }

    public Categoria(int categoriaID, String nome, String descricao) {
        this.categoriaID = categoriaID;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Categoria(String nome, String descricao) {
        this(0, nome, descricao);
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}
