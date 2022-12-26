/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20221198060008
 */
public class mecanismo {
    String escolha;
    int numero_tentativas=0;
    int acertou = 5;
    private String letra;
    private String [] palavra = {"c","a","r","r","o"} ;
    private String [] Letrasencontrada;
  

    public mecanismo() {
        this.Letrasencontrada = new String[]{"-", "-", "-", "-", "-"};
        this.palavra = new String [] {"c","a","r","r","o"};
        
    }

    public void setVerificarLista(String letra){
       // this.letra = Letra;
        for (int i = 0; i<palavra.length; i++){
            if (letra.equalsIgnoreCase(palavra[i])){
                this.Letrasencontrada [i] = letra;
                this.acertou++;
                
            }
        }
    }
   
    public void setVenceu(){        
         if (acertou == Letrasencontrada.length){
             System.out.println("voce ganhou !!");
        }
    
        
 }       
    public String [] getRetornarPalavra(){
        return this.Letrasencontrada;
    }

}
