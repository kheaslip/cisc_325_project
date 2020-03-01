package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");
        int image = intent.getIntExtra("image",0);

        ((TextView)findViewById(R.id.chat_receiver_name)).setText(name);
        ((TextView)findViewById(R.id.chat_receiver_status)).setText(status);
        ((ImageView)findViewById(R.id.chat_receiver_image)).setImageResource(image);
    }
}
