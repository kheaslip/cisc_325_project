package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if (Home.hasStatus()) {
            ((Button)findViewById(R.id.status_button)).setText(Home.getmStatus());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Home.hasStatus()) {
            ((Button)findViewById(R.id.status_button)).setText(Home.getmStatus());
        }
    }

    public void loadStatusScreen(View view) {
        startActivity(new Intent(Profile.this, statusSelectionActivity.class));
    }

    public void loadHomeScreen(View view) {
        startActivity(new Intent(Profile.this, Home.class));
    }

    public void loadEventListScreen(View view) {
        startActivity(new Intent(Profile.this, EventList.class));
    }

}
