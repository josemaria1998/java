package com.mycompany.jogodaforca;

public class Mecanismo {
    int numero_tentativas;
    
    String escolha;
    String letra;
    
    String [] letra_encontrada = { "-","-","-","-","-"};
    String [] palavra = {"c","a","r","r","o"};
    
    public void setVerificarLista(String Letra){
        this.letra = Letra;
        for (int i = 0; i<palavra.length; i++){
            
            if (letra.equalsIgnoreCase(palavra[i])){
                this.letra_encontrada [i] = letra;
            }
            if (!letra.equalsIgnoreCase(palavra[i])){                
                this.numero_tentativas = numero_tentativas++;                
            }
        }    
    }
    public void setVenceu(){
        if (letra_encontrada.equals(palavra.length)){
            System.out.println("voce ganhou !!");
        }
    }
    public String [] getRetornarPalavra(){
        return this.letra_encontrada;
    }
    public int getNumero_Tentativas(){
        return this.numero_tentativas;
    }
}