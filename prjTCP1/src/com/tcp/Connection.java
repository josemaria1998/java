
package com.tcp;

// Pacotes Utilizados pela Classe
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

// Esta classe abstrai uma conexão
// A classe Connection extends uma classe Thread
// Um Thread deve implementar um método run
class Connection extends Thread {

    // Classe usada para receber informações
    DataInputStream in;
    // Classe usada para enviar informações
    DataOutputStream out;
    // Classe usada para estabelecer uma conexão com o servidor
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        // As cláusulas try ... catch são obrigatórias para utilização 
        try {
            // Conexão criada na classe TCPServer
            clientSocket = aClientSocket;
            // Cria um InputStream para receber informações do Servidor
            in = new DataInputStream(clientSocket.getInputStream());
            // Cria um OutputStream pra enviar informações para o servidor
            out = new DataOutputStream(clientSocket.getOutputStream());
            // Inicia a Thread
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        // As cláusulas try ... catch são obrigatórias para utilização 
        // Dos DataInputStream e DataOutputStream
        try {
            // Os métodos read do DataInputStream são responsáveis por 
            // "escutar" informações vindas de outro computador.
            // Há vários métodos read. Um para cada funcionalidade.
            // Exemplos: readInt(), readDouble().
            // Os métodos read são bloqueantes. O resto do código não 
            // será executando enquanto ele não receber uma mensagem
            String data = in.readUTF();
            // Similarmente aos métodos read, os métodos write enviam 
            // uma mensagem para outro computador
            // Há vários métodos write. Um para cada funcionalidade.
            // Exemplos: writeInt(), writeDouble().
            System.out.println("Msg recebido de IP: " + 
                    clientSocket.getInetAddress());
            out.writeUTF(data);
            System.out.println("Msg enviada para IP: " + 
                    clientSocket.getInetAddress());
            // Deve haver uma correspondência entre quem envia e quem 
            // recebe a informação
            // Se uma Thread envia um inteiro pelo writeInt(), a outra Thread
            // espera que haja um readInt()
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/
            }
        }
    }
}
