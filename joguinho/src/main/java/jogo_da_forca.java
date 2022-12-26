
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20221198060008
 */
public class jogo_da_forca {
    public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);
        
       mecanismo mecanismo = new mecanismo();
        
        
        System.out.println("Bem vindo(a), ao jogo da forca! \n Antes de começar, qual é seu nome?\n");
        String Nome = sc.nextLine();
        jogador Jogador = new jogador(Nome);
        jogador.setVerificarLista(Nome);    
        
        int numero_tentativas=0;
        
        
      
        while (numero_tentativas < 5){
            
            System.out.println("digite uma letra :");
            String Letra = sc.nextLine();
            mecanismo.setVerificarLista(Letra);
            System.out.println(Arrays.toString(mecanismo.getRetornarPalavra()));
            mecanismo.setVenceu();

            numero_tentativas++;
        }
     
    }
    }
