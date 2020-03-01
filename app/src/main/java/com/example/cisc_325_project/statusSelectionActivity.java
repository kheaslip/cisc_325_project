package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class statusSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_selection);
    }


    public void updateStatus(View view) {
        ((TextView) findViewById(R.id.change_status)).setText(((TextView) view).getText());
    }
}
