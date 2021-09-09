package frexie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FileHandler {

    public static void deactivateUser() {

        int x;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"));
            for (x = 0; x < FileLoader.users.size(); x++) {
                if (!FileLoader.users.get(x).getUserName().equalsIgnoreCase(Controller.currentUser.getUserName())) {
                    bw.write(FileLoader.users.get(x).getUserName() + "," + FileLoader.users.get(x).getFirstName()
                            + "," + FileLoader.users.get(x).getLastName() + "," + FileLoader.users.get(x).getFullName()
                            + "," + FileLoader.users.get(x).getEmail() + "," + FileLoader.users.get(x).getPassword()
                            + "," + FileLoader.users.get(x).getGender() + "," + Integer.toString(FileLoader.users.get(x).getCountFriends()) + ","
                            + FileLoader.users.get(x).getStatus() + "," + FileLoader.users.get(x).getState() + "\n");
                }

            }
            bw.close();
        } catch (Exception ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure books.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }

    }

    public static void UpdateUsersFile() {
        int x;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"));
            for (x = 0; x < FileLoader.users.size(); x++) {
                if (!FileLoader.users.get(x).getUserName().equalsIgnoreCase(Controller.currentUser.getUserName())) {
                    bw.write(FileLoader.users.get(x).getUserName() + "," + FileLoader.users.get(x).getFirstName()
                            + "," + FileLoader.users.get(x).getLastName() + "," + FileLoader.users.get(x).getFullName()
                            + "," + FileLoader.users.get(x).getEmail() + "," + FileLoader.users.get(x).getPassword()
                            + "," + FileLoader.users.get(x).getGender() + "," + Integer.toString(FileLoader.users.get(x).getCountFriends()) + ","
                            + FileLoader.users.get(x).getStatus() + "," + FileLoader.users.get(x).getState() + "\n");
                } else {
                    bw.write(Controller.currentUser.getUserName() + "," + Controller.currentUser.getFirstName()
                            + "," + Controller.currentUser.getLastName() + "," + Controller.currentUser.getFullName()
                            + "," + Controller.currentUser.getEmail() + "," + Controller.currentUser.getPassword()
                            + "," + Controller.currentUser.getGender() + "," + Integer.toString(Controller.currentUser.getCountFriends()) + ","
                            + Controller.currentUser.getStatus() + "," + Controller.currentUser.getState() + "\n");
                }
            }
            bw.close();
        } catch (Exception ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure books.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }
    }

    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    public static void addToUsersFile(String userName, String firstName, String lastName, String fullName, String email, String password, String gender, int countFriends) {
        User user = new User();
        user.setFirstName(firstName);
        user.setUserName(userName);
        user.setCountFriends(countFriends);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setGender(gender);
        user.setStatus(" ");
        user.setState("true");
        FileLoader.users.add(user);
        Controller.currentUser = user;
        Controller.currentUsername = user.getUserName();
        UpdateUsersFile();
    }

//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    public static void createNewUserFile() {

        try {
            File file = new File(Controller.currentUsername + ".txt");
            file.createNewFile();
        } catch (IOException ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }

    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    public static void addFriend(String username) {

        try {
            int x;
            ArrayList<String> temp = new ArrayList<String>();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(Controller.currentUser.getUserName() + ".txt"));
                for (x = 0; x < Controller.currentUser.getFriendsNames().size(); x++) {
                    bw.write(Controller.currentUser.getFriendsNames().get(x) + "\n");
                }
                bw.write(username + "\n");
                bw.close();
            } catch (Exception ex) {
                ImageIcon xMark = new ImageIcon("xMark50.png");
                JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
            }
            /////////////////////////////////////////////
            temp = FileLoader.loadFriends(username);
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(username + ".txt"));
            for (x = 0; x < temp.size(); x++) {
                bw2.write(temp.get(x) + "\n");
            }
            bw2.write(Controller.currentUser.getUserName() + "\n");
            bw2.close();
        } catch (IOException ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }

    }

//////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
    public static void addFirstFriend(String username) {
        BufferedWriter bw2 = null;
        try {
            bw2 = new BufferedWriter(new FileWriter(username + ".txt"));
            bw2.write("1" + "\n");
            bw2.close();
        } catch (IOException ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }
    }
    
    
    
    public static void deleteFriend(String username)
    {
        
          try {
            int x;
            ArrayList<String> temp = new ArrayList<String>();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(Controller.currentUser.getUserName() + ".txt"));
                for (x = 0; x < Controller.currentUser.getFriendsNames().size(); x++) {
                  if(!Controller.currentUser.getFriendsNames().get(x).equalsIgnoreCase(username))     bw.write(Controller.currentUser.getFriendsNames().get(x) + "\n");
                }
               
                bw.close();
            } catch (Exception ex) {
                ImageIcon xMark = new ImageIcon("xMark50.png");
                JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
            }
            /////////////////////////////////////////////
            temp = FileLoader.loadFriends(username);
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(username + ".txt"));
            for (x = 0; x < temp.size(); x++) {
            if(!temp.get(x).equalsIgnoreCase(Controller.currentUser.getUserName())) bw2.write(temp.get(x) + "\n");
            }
            bw2.close();
        } catch (IOException ex) {
            ImageIcon xMark = new ImageIcon("xMark50.png");
            JOptionPane.showMessageDialog(null, "File not found!\nplease make sure UserName.txt is in program folder and restart the application", "Operation failed", JOptionPane.INFORMATION_MESSAGE, xMark);
        }
        
        
        
    }
}
