package com.mycompany.jogodaforca;

public class Jogador {
    private String nome;
    private int vidas = 0;
    
    public void setVidas(int vidas){
        this.vidas = vidas;
    }
    public void setReceberNome(String nome){
        this.nome = nome;
    }    
}