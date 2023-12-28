import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ServerSocket ss;
    static ArrayList<JogoDaVelhaHandler> jogadores = new ArrayList<>();

    public static void main(String args[]) {
        try {
            ss = new ServerSocket(1234);
            System.out.println("Aguardando conexões...");

            while (true) {
                if (jogadores.size() < 2) {
                    Socket s = ss.accept();
                    System.out.println("Cliente conectado: " + s);

                    JogoDaVelhaHandler novoJogador = new JogoDaVelhaHandler(s);
                    jogadores.add(novoJogador);

                    Thread t = new Thread(novoJogador);
                    t.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class JogoDaVelhaHandler implements Runnable {
        Socket socket;
        DataInputStream dis;
        DataOutputStream dout;
        Jogo jogo;

        public JogoDaVelhaHandler(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dout = new DataOutputStream(socket.getOutputStream());
                jogo = new Jogo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
    try {
        while (true) {
            int linha = dis.readInt();
            int coluna = dis.readInt();

            // Verifica se é uma jogada válida
            if (jogo.fazerJogada(linha, coluna)) {
                char vencedor = jogo.verificarVencedor();
                if (vencedor != '-') {
                    System.out.println("Jogo finalizado! Vencedor: " + vencedor);
                }

                // Envie a jogada para todos os jogadores
                for (JogoDaVelhaHandler j : jogadores) {
                    j.dout.writeInt(linha);
                    j.dout.writeInt(coluna);
                    j.dout.writeChar(jogo.getJogadorAtual()); // Envie o símbolo do jogador atual
                    j.dout.flush();
                }

                if (vencedor != '-') {
                    break; // Encerra o loop quando o jogo terminar
                }
            } else {
                System.out.println("Jogada inválida!");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    }
}
