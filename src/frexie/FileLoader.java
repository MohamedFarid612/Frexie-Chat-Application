
package frexie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FileLoader {
    
    public static ArrayList<User> users = new ArrayList<>();
    

    public static void FileLoading() {
        try {
            
          
              users.clear();
          
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String temp;
            while ((temp = br.readLine()) != null) {

                User tempUser = new User();
                StringTokenizer st = new StringTokenizer(temp, ",");
                while (st.hasMoreTokens()) {
                    tempUser.setUserName(st.nextToken());
                    tempUser.setFirstName(st.nextToken());
                    tempUser.setLastName(st.nextToken());
                    tempUser.setFullName(st.nextToken());
                    tempUser.setEmail(st.nextToken());
                    tempUser.setPassword(st.nextToken());
                    tempUser.setGender(st.nextToken());
                    tempUser.setCountFriends(Integer.parseInt(st.nextToken()));
                    tempUser.setStatus(st.nextToken());
                    String tempState=st.nextToken();
                    tempUser.setState(tempState);
                    users.add(tempUser);
                }
            }
            br.close();
        } catch (Exception ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure users.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
            return;
        }
    }
    public static ArrayList loadFriends(String fileName)
    {
        
         ArrayList<String> friends=new ArrayList();
         try {
            BufferedReader br = new BufferedReader(new FileReader(fileName+".txt"));
            String temp;
           
            while ((temp = br.readLine()) != null) {
                
                StringTokenizer st = new StringTokenizer(temp, "\n");
                while (st.hasMoreTokens()) {
                    String tempString=st.nextToken();
                       friends.add(tempString);
                         }
            }
            br.close();
        } catch (Exception ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure thisuser's.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }
         
    return friends;    
    }
        
        
    
    
}
