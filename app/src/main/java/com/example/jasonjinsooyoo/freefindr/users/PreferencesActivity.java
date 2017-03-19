package com.example.jasonjinsooyoo.freefindr.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jasonjinsooyoo.freefindr.ENUM.Categories;
import com.example.jasonjinsooyoo.freefindr.EventFindR;
import com.example.jasonjinsooyoo.freefindr.MapsActivity;
import com.example.jasonjinsooyoo.freefindr.R;
import com.example.jasonjinsooyoo.freefindr.SingleEventActivity;

import java.util.LinkedList;
import java.util.List;

public class PreferencesActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        String name = getIntent().getStringExtra("Name");
        String email = getIntent().getStringExtra("Email");

        TextView tv = (TextView) findViewById(R.id.username_txt);
        // create new user
        tv.setText(name);
        user = new User(email);
        user.setEmail(email);
        user.setName(name);
    }

    // choose preferences
    public void onButtonClick(View v) {
        List<Categories> c = new LinkedList<Categories>();
        int check[] = {R.id.cbArt, R.id.cbBusiness, R.id.cbFood, R.id.cbTech, R.id.cbSports, R.id.cbGame, R.id.cbSocial, R.id.cbOther, R.id.cbHealth};
        if (v.getId() == R.id.Bcomplete){
            for (int i = 0; i < check.length; i++) {
                if(((CheckBox)findViewById(check[i])).isChecked()) {
                    switch(check[i]) {
                        case R.id.cbArt:
                            c.add(Categories.ART);
                            break;
                        case R.id.cbBusiness:
                            c.add(Categories.BUSINESS);
                            break;
                        case R.id.cbFood:
                            c.add(Categories.FOOD);
                            break;
                        case R.id.cbGame:
                            c.add(Categories.GAME);
                            break;
                        case R.id.cbSports:
                            c.add(Categories.SPORTS);
                            break;
                        case R.id.cbTech:
                            c.add(Categories.TECH);
                            break;
                        case R.id.cbHealth:
                            c.add(Categories.HEALTH);
                            break;
                        case R.id.cbOther:
                            c.add(Categories.OTHER);
                            break;
                        case R.id.cbSocial:
                            c.add(Categories.SOCIAL);
                            break;
                        default:
                            break;
                    }
                }
            }
            for (Categories i: c) {
                user.addCategory(i);
            }
            //add user to singleton
            UserManager.getOurInstance().addUser(user);
            String email = user.getEmail();

            Intent i = new Intent(PreferencesActivity.this, MapsActivity.class);
            i.putExtra("Email", email);
            startActivity(i);
        }
    }


}

