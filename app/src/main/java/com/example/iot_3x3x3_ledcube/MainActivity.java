package com.example.iot_3x3x3_ledcube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphFloatingActionButton;
import soup.neumorphism.NeumorphImageButton;

public class MainActivity extends AppCompatActivity {
    DatabaseReference RootRef;
    NeumorphCardView displayonoff, buttononoff, pattern1, pattern4, pattern7, pattern2, pattern5, pattern8, pattern3, pattern6, pattern9;
    SwitchCompat lightSw;

    android.content.SharedPreferences SharedPreferences=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RootRef = FirebaseDatabase.getInstance().getReference();
//
        lightSw = findViewById(R.id.lightSw);
//
        buttononoff =(NeumorphCardView) findViewById(R.id.buttononoff);
        displayonoff =(NeumorphCardView) findViewById(R.id.displayonoff);

        pattern1 =(NeumorphCardView) findViewById(R.id.pattern1);
        pattern4 =(NeumorphCardView) findViewById(R.id.pattern4);
        pattern7 =(NeumorphCardView) findViewById(R.id.pattern7);

        pattern2 =(NeumorphCardView) findViewById(R.id.pattern2);
        pattern5 =(NeumorphCardView) findViewById(R.id.pattern5);
        pattern8 =(NeumorphCardView) findViewById(R.id.pattern8);

        pattern3 =(NeumorphCardView) findViewById(R.id.pattern3);
        pattern6 =(NeumorphCardView) findViewById(R.id.pattern6);
        pattern9 =(NeumorphCardView) findViewById(R.id.pattern9);

        SharedPreferences =getSharedPreferences( "night", 0);
        Boolean booleanValue = SharedPreferences.getBoolean("night_mode",true);
        if (booleanValue) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            lightSw.setChecked(true);
        }
        lightSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    lightSw.setChecked(true);
                    SharedPreferences.Editor editor = SharedPreferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.apply();
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    lightSw.setChecked(false);
                    SharedPreferences.Editor editor = SharedPreferences.edit();
                    editor.putBoolean("night_mode", false);
                    editor.apply();
                }
            }
        });
        buttononoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(11);

            }
        });
        pattern1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(11);

            }
        });
        pattern4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(21);

            }
        });
        pattern7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(31);

            }
        });
        pattern2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(12);

            }
        });
        pattern5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(22);

            }
        });
        pattern8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(32);

            }
        });
        pattern3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(13);

            }
        });
        pattern6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(23);

            }
        });
        pattern9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootRef.child("Cube").child("pattern").setValue(33);

            }
        });

        buttononoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    RootRef.child("Cube").child("state").setValue(0);
            }
        });


    }
}