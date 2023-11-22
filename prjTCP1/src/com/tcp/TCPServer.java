package com.tcp;


import java.net.*;
import java.io.*;

// Esta classe implementa um servidor que se comunicar� com um cliente
public class TCPServer {

    public static void main(String args[]) {
        // Porta que ir� identificar o processo no servidor
        // O cliente deve se comunicar com o servidor utilizando a mesma porta
        int serverPort = 7896;
        // As cl�usulas try ... catch s�o obrigat�rias para utiliza��o 
        // do ServerSocket
        try {
            // Implementa a cria��o de um servidor socket, respons�vel 
            // por estabelecer uma conex�o com o cliente
            ServerSocket listenSocket = new ServerSocket(serverPort);
            // A execu��o do la�o infinito abaixo permite que v�rios clientes
            // possam se conectar ao servidor. O servidor fica em execu��o
            // At� que algum cliente se conecte
            while (true) {
                System.out.println("Esperando conex�o com cliente.");
                // O m�todo accept() � bloqueante. o programa n�o prossegue 
                // At� que um cliente se conecte
                Socket clientSocket = listenSocket.accept();
                // Para cada conex�o com o cliente, � criada uma Connection
                // que vai ficar respons�vel por se comunidar com o cliente
                System.out.println("Conex�o estabelecida com o IP: " +
                        clientSocket.getInetAddress());
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }
}
