package frexie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class User {

    private String userName;
    private String firstName;
    private String fullName;
    private String lastName;
    private String email;
    private String gender;
    private String password;
    private String state;
    private int countFriends;
    private String Status;
    private ArrayList<String> friendsNames;
    private ArrayList<User> friends;

    
    

    public User() {
         
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

  

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCountFriends() {
        return countFriends;
    }

    public void setCountFriends(int countFriends) {
        this.countFriends = countFriends;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getFriendsNames() {
        return friendsNames;
    }

    public void setFriendsNames() {
        this.friendsNames = FileLoader.loadFriends(this.userName);
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
