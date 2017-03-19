package com.example.jasonjinsooyoo.freefindr.users;

import com.example.jasonjinsooyoo.freefindr.ENUM.Categories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by michellewong on 2017-03-19.
 */

public class JSONParser_User {

    public static void parseJSONUser(String string) throws JSONException {
        JSONArray myArray = new JSONArray(string);
        for (int i=0; i<myArray.length(); i++) {
            JSONObject curObj = myArray.getJSONObject(i);
            storeToManager(curObj);
        }
    }

    // parses and stores data to UserManager
    public static void storeToManager(JSONObject curObj) throws JSONException {
        String id = curObj.getString("email");
        String name = curObj.getString("name");
        String[] type = curObj.getString("preferences").split(",");
        User user = new User(id);
        user.setName(name);
        for (String i : type) {
            if (i.equals("ARTS") || i.equals("ART")) {
                user.addCategory(Categories.ART);
            } else if (i.equals("BUSINESS")) {
                user.addCategory(Categories.BUSINESS);
            } else if (i.equals("FOOD")) {
                user.addCategory(Categories.FOOD);
            } else if (i.equals("GAME")) {
                user.addCategory(Categories.GAME);
            } else if (i.equals("HEALTH")) {
                user.addCategory(Categories.HEALTH);
            } else if (i.equals("OTHER")) {
                user.addCategory(Categories.OTHER);
            } else if (i.equals("SOCIAL")) {
                user.addCategory(Categories.SOCIAL);
            } else if (i.equals("SPORTS")) {
                user.addCategory(Categories.SPORTS);
            } else if (i.equals("TECH")) {
                user.addCategory(Categories.TECH);
            } else {
                throw new RuntimeException("Nonexistent category");
            }
        }
        UserManager.getOurInstance().addUser(user);
    }

}