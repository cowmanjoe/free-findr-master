package com.example.jasonjinsooyoo.freefindr.users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jasonjinsooyoo.freefindr.R;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        String s = getIntent().getStringExtra("Info");
        TextView tv = (TextView)findViewById(R.id.user_info);
        tv.setText(s);


    }
}