package com.mycompany.jogodaforca;

public class Mecanismo {
    private int numero = 0;
    
    String escolha;
    String letra;
    
    String [] letra_encontrada = { "-","-","-","-","-"};
    String [] palavra = {"c","a","r","r","o"};
    
    public void setVerificarLista(String Letra){
        this.letra = Letra;
        for (int i = 0; i<palavra.length; i++){           
            if (letra.equalsIgnoreCase(this.palavra[i])){
                this.letra_encontrada [i] = letra;
            }
            else {                
                this.numero = numero + 1;
            }
        }    
    }       
    public String [] getRetornarPalavra(){
        return this.letra_encontrada;
    }
    public int getNumero_Tentativas(){
        return this.numero_tentativas;
    }
    public int getRetornarNumero(){
        return this.numero;
    }
}