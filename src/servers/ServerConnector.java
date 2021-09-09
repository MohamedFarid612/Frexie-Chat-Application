package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import view.GlobalChat;

public class ServerConnector implements Runnable {

    Socket socket;
    BufferedReader br;
    PrintWriter pw;

    public ServerConnector(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String temp;
        while (true) {
            try {
                temp = br.readLine();
                GlobalChat.k.setText(GlobalChat.k.getText() + "\n\n" + temp);
            } catch (IOException ex) {
               

            }
        }
    }

}
