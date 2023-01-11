public class jogador {
    int numero_tentativas = 0;
    String nome_jogador ;
    
    public void setReceberNome(String nome){
        this.nome_jogador = nome;
    }
    public void setNumeroTentativas(int Numero_tentativas){
        this.numero_tentativas = Numero_tentativas;
    }

    public int getNumeroTentativas(){
        return numero_tentativas;
    }
}
