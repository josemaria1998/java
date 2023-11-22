package com.tcp;


import java.net.*;
import java.io.*;

// Esta classe implementa um servidor que se comunicará com um cliente
public class TCPServer {

    public static void main(String args[]) {
        // Porta que irá identificar o processo no servidor
        // O cliente deve se comunicar com o servidor utilizando a mesma porta
        int serverPort = 7896;
        // As cláusulas try ... catch são obrigatórias para utilização 
        // do ServerSocket
        try {
            // Implementa a criação de um servidor socket, responsável 
            // por estabelecer uma conexão com o cliente
            ServerSocket listenSocket = new ServerSocket(serverPort);
            // A execução do laço infinito abaixo permite que vários clientes
            // possam se conectar ao servidor. O servidor fica em execução
            // Até que algum cliente se conecte
            while (true) {
                System.out.println("Esperando conexão com cliente.");
                // O método accept() é bloqueante. o programa não prossegue 
                // Até que um cliente se conecte
                Socket clientSocket = listenSocket.accept();
                // Para cada conexão com o cliente, é criada uma Connection
                // que vai ficar responsável por se comunidar com o cliente
                System.out.println("Conexão estabelecida com o IP: " +
                        clientSocket.getInetAddress());
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }
}
