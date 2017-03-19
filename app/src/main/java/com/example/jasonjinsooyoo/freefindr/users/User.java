package com.example.jasonjinsooyoo.freefindr.users;

import com.example.jasonjinsooyoo.freefindr.ENUM.Categories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michellewong on 2017-03-19.
 */

public class User {

    String name;
    String email;
    List<Categories> preferences;

    public User(String id) {
        name = "";
        email = id; // unique identifier (Google Account)
        preferences = new ArrayList<Categories>();
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String e) {
        email = e;
    }

    public String getEmail() {
        return email;
    }

    public List getCategories() {
        return preferences;
    }

    public void addCategory(Categories c) {
        preferences.add(c);
    }

    public String toString() {
        return "User [id=" + email + ", Name=" + name + ", preferences=" + preferences + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o==null || o.getClass() != this.getClass()) return false;
        User a = (User) o;
        return this.email.equals(a.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}

