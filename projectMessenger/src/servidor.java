import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class servidor {
    static ServerSocket ss;
    static ArrayList<DataOutputStream> outputStreams = new ArrayList<>();
    
    public static void main(String args[]) {
        try {
            ss = new ServerSocket(1234);
            System.out.println("Aguardando conexões...");
            
            while (true) {
                Socket s = ss.accept();
                System.out.println("Cliente conectado: " + s);
                
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                outputStreams.add(dout);
                DataInputStream din = new DataInputStream(s.getInputStream());
        
                Thread t = new Thread(new ClientHandler(s, din));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static class ClientHandler implements Runnable {
        Socket socket;
        DataInputStream dis;

        public ClientHandler(Socket socket, DataInputStream dis) {
            this.socket = socket;
            this.dis = dis;
        }

        public void run() {
            try {
                String msgin = "";
                while (true) {
                    msgin = dis.readUTF();
                    System.out.println(msgin);

                    for (DataOutputStream dout : outputStreams) {
                        if (dout != null && dout != socket.getOutputStream()) {
                            dout.writeUTF(msgin);
                            dout.flush();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
