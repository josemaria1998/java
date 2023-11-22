package com.udp;

// Importa a biblioteca com classes utilizadas para conexão entre processos
import java.net.*;
// Importa classes de entrada e saída de dados
import java.io.*;
// Scanner é um classe utilizada para ler informações a partir do teclado
import java.util.Scanner;

public class UDPClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Guada a mensagem e o IP para onde a mensagem será enviada
        String msg = null;
        String strIP = null;

        System.out.println("Digite uma mensagem:");
        msg = sc.nextLine();
        System.out.println("Digite o IP para envio da mensagem:");
        strIP = sc.nextLine();

        // Implementa uma classe para abstrair um Socket de Datagrama
        DatagramSocket aSocket = null;
        try {
            // Cria um Socket do tipo Datagrama
            aSocket = new DatagramSocket();
            // Transforma o conteúdo do objeto em um conjunto de bytes para ser transmitido
            byte[] m = msg.getBytes();
            // Pega o endereço Internet a partir de um DNS hostname, http://www.ifrn.edu.br
            InetAddress aHost = InetAddress.getByName(strIP);
            // Porta do processo para onde será encaminhada a mensagem
            int serverPort = 6789;
            // Cria um Datagrama com base nos parâmetros de entrada
            DatagramPacket request = new DatagramPacket(m, 
                    m.length, aHost, serverPort);
            // Envia a mensagem através do Socket criado para o servidor
            aSocket.send(request);

            // Cria um buffer para armazenar a mensagem de retorno do servidor
            byte[] buffer = new byte[1000];
            // Datagrama criado para receber a mensagem do servidor
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            // A mensagem do servidor é recebida através do Socket criado
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
