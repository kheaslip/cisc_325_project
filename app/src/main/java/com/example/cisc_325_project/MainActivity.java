package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loadStatusScreen(View view) {
        startActivity(new Intent(MainActivity.this, statusSelectionActivity.class));

    }

    public void loadNewFriendScreen(View view) {
        startActivity(new Intent(MainActivity.this, addFriendActivity.class));
    }

    public void loadEventListScreen(View view) {
        startActivity(new Intent(MainActivity.this, events.class));
    }

    public void loadProfileScreen(View view) {
        startActivity(new Intent(MainActivity.this, Profile.class));
    }
}
