package com.projeto;

public class Cadastro {
    private String nome; 
    private float peso; 
    private int idade;
    
    public Cadastro(String nome, float peso, int idade) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
    public String toString() {
        return "nome: " + nome + "\npeso:" + peso + "\nidade: " + idade;
    }
    
}
