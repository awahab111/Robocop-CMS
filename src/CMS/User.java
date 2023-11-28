package CMS;

import CMS.DBHandler.UserLoginHandler;

public class User {
    int user_ID;
    String username;
    String password;

    UserLoginHandler userLoginHandler = new UserLoginHandler();

    public void addUser(String username, String password){
        userLoginHandler.insertUser(username, password);
    }

    public int getUserID(String username, String password){
        return userLoginHandler.getUserID(username, password);
    }


    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}