
package servers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DouClient {
    
      public static Socket socket;
      public static BufferedReader br;
      public static PrintWriter pw;

    public DouClient() throws IOException {
        
        socket = new Socket("localhost", 2222);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        
    }
    
}
 