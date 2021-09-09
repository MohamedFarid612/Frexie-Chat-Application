package frexie;

import java.util.ArrayList;

public class Finder {

    public static User FindFriend(String username) {

        for (int i = 0; i < FileLoader.users.size(); i++) {
            if (FileLoader.users.get(i).getUserName().equalsIgnoreCase(username)) {
                return FileLoader.users.get(i);
            }
        }
        return null;
    }

    public static boolean isAlreadyFriend(String Username) {

        for (int i = 0; i < Controller.currentUser.getFriendsNames().size(); i++) {
            if (Controller.currentUser.getFriendsNames().get(i).equalsIgnoreCase(Username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOnline(String Username) {

        if (Controller.selectedUser.getState().equalsIgnoreCase("true")) {
            return true;
        }

        return false;
    }

    public static ArrayList<User> loadOnlineFriends() {
        FileLoader.FileLoading();
        ArrayList<String> temp = Controller.currentUser.getFriendsNames();
        ArrayList<User> temp2 = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            String tempString = temp.get(i);
            for (int j = 0; j < FileLoader.users.size(); j++) {
                if (tempString.trim().equalsIgnoreCase(FileLoader.users.get(j).getUserName()) && FileLoader.users.get(j).getState().equalsIgnoreCase("true") ) {
                    temp2.add(FileLoader.users.get(j));
                }
            }
        }
        return temp2;
    }

}
