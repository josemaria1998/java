
import java.util.Arrays;
import java.util.Scanner;


public class jogo_da_forca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mecanismo mecanismo = new mecanismo();
        jogador Jogador = new jogador();    
        
        String jogo_Terminou = "False";
        
        while (jogo_Terminou != "True" ){
            
            System.out.println("digite uma letra :");
            String Letra = sc.nextLine();
            mecanismo.setVerificarLista(Letra);
            System.out.println(Arrays.toString(mecanismo.getRetornarPalavra()));
            
            if (Jogador.getNumeroTentativas() == 5){
                jogo_Terminou = "True";
            }
            else {
                jogo_Terminou = "False";
            }
        }
    }
}
