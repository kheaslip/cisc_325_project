package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CreateEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

    public void createEventButton(View view) {
        (Toast.makeText(this, "Not able to create events until later in development", Toast.LENGTH_LONG)).show();
    }
}
