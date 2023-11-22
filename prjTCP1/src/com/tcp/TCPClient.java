package com.tcp;

// Pacotes Utilizados pela Classe
import java.net.*;
import java.io.*;
import java.util.Scanner;

// Esta classe implementa um cliente que se comunicar� com um servidor
public class TCPClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Guarda o IP do servidor
        String strIP = null;
        // Guarda a mensagem que ser� enviada para o servidor
        String msg = null;
        // Porta que ir� identificar o processo no servidor
        // O cliente deve se comunicar com o servidor utilizando a mesma porta
        int serverPort = 7896;
        // Implementa a conex�o que ser� utilizada com o servidor
        Socket s = null;

        // Pega as informa��es de IP e msg que ser�o enviadas ao servidor
        System.out.println("Digite o IP para envio da mensagem:");
        strIP = sc.nextLine();
        System.out.println("Digite uma mensagem:");
        msg = sc.nextLine();

        // As cl�usulas try ... catch s�o obrigat�rias para utiliza��o 
        // Socket, DataInputStream e DataOutputStream
        try {
            // Tenta criar uma conex�o com o servidor em um IP e Porta
            s = new Socket(strIP, serverPort);
            // A partir da conex�o bem sucedida, o cliente pode instaciar
            // um DataInputStream (para receber dados do servidor) e 
            // um DataOutputStream para enviar dados para o servidor
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            // Os m�todos write do DataOutpuStream s�o respons�veis por 
            // enviar informa��es para outro computador.
            // H� v�rios m�todos write. Um para cada funcionalidade.
            // Exemplos: writeInt(), writeDouble().
            // Os m�todos write n�o s�o bloqueantes, diferentemente dos m�todos
            // read.
            out.writeUTF(msg); 
            // Ap�s envio de uma mensagem, o cliente aguarda o retorno do 
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
