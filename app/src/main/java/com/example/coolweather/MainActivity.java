package com.example.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String str = null;
        if(str.equals("1")){
            str = "2";
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}