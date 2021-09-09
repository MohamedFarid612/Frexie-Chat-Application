
package servers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server2 {

    private Socket socket;
    private ServerSocket serverSocket;
    private BufferedReader bf;
    private PrintWriter pw;
    public static int port = 2222;
    private static ArrayList<ServerHandler> serverHandlers=new ArrayList<ServerHandler>();
    private static ExecutorService pool= Executors.newFixedThreadPool(200);
    

    public Server2() throws IOException {
        serverSocket = new ServerSocket(port);
    }
     public static void main(String[] args) {
         
        try {
            
            Server2 server=new Server2();
            while(true) 
            {
            server.socket=server.serverSocket.accept();
            System.out.println("[server]----connected");
            ServerHandler clientHandler= new ServerHandler(server.socket,serverHandlers);
            serverHandlers.add(clientHandler);
            pool.execute(clientHandler);
            
            
            }
        } catch (IOException ex) {
           
        }
         
         
         
         
         
     }

     
}

