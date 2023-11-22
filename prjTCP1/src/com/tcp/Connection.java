
package com.tcp;

// Pacotes Utilizados pela Classe
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

// Esta classe abstrai uma conex�o
// A classe Connection extends uma classe Thread
// Um Thread deve implementar um m�todo run
class Connection extends Thread {

    // Classe usada para receber informa��es
    DataInputStream in;
    // Classe usada para enviar informa��es
    DataOutputStream out;
    // Classe usada para estabelecer uma conex�o com o servidor
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        // As cl�usulas try ... catch s�o obrigat�rias para utiliza��o 
        try {
            // Conex�o criada na classe TCPServer
            clientSocket = aClientSocket;
            // Cria um InputStream para receber informa��es do Servidor
            in = new DataInputStream(clientSocket.getInputStream());
            // Cria um OutputStream pra enviar informa��es para o servidor
            out = new DataOutputStream(clientSocket.getOutputStream());
            // Inicia a Thread
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        // As cl�usulas try ... catch s�o obrigat�rias para utiliza��o 
        // Dos DataInputStream e DataOutputStream
        try {
            // Os m�todos read do DataInputStream s�o respons�veis por 
            // "escutar" informa��es vindas de outro computador.
            // H� v�rios m�todos read. Um para cada funcionalidade.
            // Exemplos: readInt(), readDouble().
            // Os m�todos read s�o bloqueantes. O resto do c�digo n�o 
            // ser� executando enquanto ele n�o receber uma mensagem
            String data = in.readUTF();
            // Similarmente aos m�todos read, os m�todos write enviam 
            // uma mensagem para outro computador
            // H� v�rios m�todos write. Um para cada funcionalidade.
            // Exemplos: writeInt(), writeDouble().
            System.out.println("Msg recebido de IP: " + 
                    clientSocket.getInetAddress());
            out.writeUTF(data);
            System.out.println("Msg enviada para IP: " + 
                    clientSocket.getInetAddress());
            // Deve haver uma correspond�ncia entre quem envia e quem 
            // recebe a informa��o
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
