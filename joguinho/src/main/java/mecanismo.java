public class mecanismo { 
    int tentativas = 0;
    private String letra;
    private String [] palavra = {"c","a","r","r","o"} ;
    private String [] Letrasencontrada;
  

    public mecanismo() {
        this.Letrasencontrada = new String[]{"-", "-", "-", "-", "-"};
        this.palavra = new String [] {"c","a","r","r","o"};        
    }

    public void setVerificarLista(String letra){
        this.letra = letra;
        for (int i = 0; i<palavra.length; i++){
            if (letra.equalsIgnoreCase(palavra[i])){
                this.Letrasencontrada [i] = letra;                
            }
            else {
                this.tentativas ++;
            }
        }
    } 
    
    public int gettentativas(){
        return tentativas;
    }
    public String [] getRetornarPalavra(){
        return this.Letrasencontrada;
    }

}
