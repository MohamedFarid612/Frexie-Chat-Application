package servers;

import frexie.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import view.GlobalChat;

public class GlobalServerConnector implements Runnable {

    Socket socket;
    BufferedReader br;
    PrintWriter pw; 

    public GlobalServerConnector(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String temp;
        while (socket.isConnected()) {
            try {
                if (Controller.flagGlobalChat == true) {
                    temp = br.readLine();
                    if(!temp.contains("null"))
                    GlobalChat.k.setText(GlobalChat.k.getText() + "\n\n" + temp);
                }
            } catch (IOException ex) {

            }
        }
    }

}
