package com.mycompany.jogodaforca;

import java.util.Arrays;
import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Mecanismo mecanismo = new Mecanismo();
        Jogador jogador = new Jogador();
        
        System.out.println("Bem vindo(a), ao jogo da forca! Antes de começar, qual é seu nome?");
        String Nome = sc.nextLine();
        jogador.setReceberNome(Nome);
        
        System.out.println("Bom Jogo "+jogador.getRetornarNome())
        int numero_tentativas = 0;

        while (this.numero_tentativas < 6){
            if (this.numero_tentativas < 6){
                System.out.println("digite uma letra :");
                String Letra = sc.nextLine();
                mecanismo.setVerificarLista(Letra);
                System.out.println(Arrays.toString(mecanismo.getRetornarPalavra()));
                mecanismo.getRetornarNumero().numero_tentativas;

            }
            if (this.numero_tentativas == 6){
                System.out.println("Boa sorte na Proxima, Porque voce morreu");
            }
            
        }
    System.out.println("FIM DE JOGO");
    }
}
