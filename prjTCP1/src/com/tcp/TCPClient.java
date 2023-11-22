package com.tcp;

// Pacotes Utilizados pela Classe
import java.net.*;
import java.io.*;
import java.util.Scanner;

// Esta classe implementa um cliente que se comunicará com um servidor
public class TCPClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Guarda o IP do servidor
        String strIP = null;
        // Guarda a mensagem que será enviada para o servidor
        String msg = null;
        // Porta que irá identificar o processo no servidor
        // O cliente deve se comunicar com o servidor utilizando a mesma porta
        int serverPort = 7896;
        // Implementa a conexão que será utilizada com o servidor
        Socket s = null;

        // Pega as informações de IP e msg que serão enviadas ao servidor
        System.out.println("Digite o IP para envio da mensagem:");
        strIP = sc.nextLine();
        System.out.println("Digite uma mensagem:");
        msg = sc.nextLine();

        // As cláusulas try ... catch são obrigatórias para utilização 
        // Socket, DataInputStream e DataOutputStream
        try {
            // Tenta criar uma conexão com o servidor em um IP e Porta
            s = new Socket(strIP, serverPort);
            // A partir da conexão bem sucedida, o cliente pode instaciar
            // um DataInputStream (para receber dados do servidor) e 
            // um DataOutputStream para enviar dados para o servidor
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            // Os métodos write do DataOutpuStream são responsáveis por 
            // enviar informações para outro computador.
            // Há vários métodos write. Um para cada funcionalidade.
            // Exemplos: writeInt(), writeDouble().
            // Os métodos write não são bloqueantes, diferentemente dos métodos
            // read.
            out.writeUTF(msg); 
            // Após envio de uma mensagem, o cliente aguarda o retorno do 
            // servidor. 
            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {/*close failed*/
            }
        }
    }
}
