
package servers;

import frexie.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import view.DouChat;
import view.GlobalChat;


public class DouServerConnector implements Runnable {
  
    
    
    
    Socket socket;
    BufferedReader br;
    PrintWriter pw; 

    public DouServerConnector(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        String temp;
        while (socket.isConnected()) {
            try {
                
                    temp = br.readLine();
                     if(!temp.contains("null") && (temp.contains("["+Controller.selectedUser.getUserName()+"]") || (temp.contains("["+Controller.currentUser.getUserName()+"]"))))
                     DouChat.chat.setText(DouChat.chat.getText() + "\n\n" + temp);
              
            } catch (IOException ex) {

            }
        }
    }

}

    
    
    

