package theordersystem.db.entities;

import java.time.LocalDate;

public class Animal 
{
    private int cod;
    private String nome;
    private double peso;
    private LocalDate dtnasc;
    private Raca raca;

    public Animal() {
        this(0,"",0,null,null);
    }

    public Animal(int cod, String nome, double peso, LocalDate dtnasc, Raca raca) {
        this.cod = cod;
        this.nome = nome;
        this.peso = peso;
        this.dtnasc = dtnasc;
        this.raca = raca;
    }

    public Animal(String nome, double peso, LocalDate dtnasc, Raca raca) {
        this(0,nome,peso,dtnasc,raca);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(LocalDate dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return nome;
    }
}
