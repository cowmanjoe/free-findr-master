package com.example.jasonjinsooyoo.freefindr.users;

import java.util.ArrayList;

/**
 * Created by michellewong on 2017-03-19.
 */

public class UserManager {

    private static UserManager ourInstance = new UserManager();
    private ArrayList userList;

    public static UserManager getOurInstance() {
        return ourInstance;
    }

    private UserManager() {
        userList = new ArrayList<User>();
    }

    public void addUser(User u) {
        if (!userList.contains(u)) {
            userList.add(u);
        }
    }

    public ArrayList getUserList() {
        return userList;
    }

    public User getUser(String email) {
        User u = new User(email);
        if (userList.contains(u))
            return (User) userList.get(userList.indexOf(u));
        return null;
    }

    public void removeUser(String email) {
        User u = new User(email);
        if (userList.contains(u)) {
            userList.remove(userList.indexOf(u));
        }
    }
    public boolean doesContain(String email) {
        User u = new User(email);
        if (userList.contains(u))
            return true;
        return false;
    }

    public int numUsers() {
        return userList.size();
    }
}


