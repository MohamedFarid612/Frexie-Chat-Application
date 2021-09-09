package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler implements Runnable {
 
    Socket socket;
    BufferedReader br;
    PrintWriter pw;
    ArrayList<ServerHandler> clients = new ArrayList<ServerHandler>();

    public ServerHandler(Socket socket, ArrayList<ServerHandler> clients) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        this.clients = clients;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String temp = br.readLine();
                sendAll(temp);
            }
        } catch (IOException ex) {
           
        }

    }

    public void sendAll(String temp) {
        for (ServerHandler client : this.clients) {
            client.pw.println(temp);
        }

    }

}
