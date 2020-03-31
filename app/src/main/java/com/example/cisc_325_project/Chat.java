package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static androidx.annotation.InspectableProperty.ValueType.GRAVITY;

public class Chat extends AppCompatActivity {

    int count = 0;
    String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        status = intent.getStringExtra("status");
        int image = intent.getIntExtra("image",0);

        ((TextView)findViewById(R.id.chat_receiver_name)).setText(name);
        ((TextView)findViewById(R.id.chat_receiver_status)).setText(status);
        ((ImageView)findViewById(R.id.chat_receiver_image)).setImageResource(image);
    }

    public void addMessageToChatLog(View view) {
        TextView chatBar = (TextView) findViewById(R.id.chat_text_bar);
        CharSequence message = chatBar.getText();
        chatBar.setText("");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.chat_log);
        TextView textView = new TextView(this);

        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setText(message);
        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView.setTextSize(20);
        textView.setGravity(Gravity.RIGHT);
        //left, top, right, bottom
        textView.setPadding(0 , 0, 10, 0 );
        linearLayout.addView(textView);
        count = count + 1;
        respond(count);




    }

    public void respond(int count) {
        if (count == 1) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.chat_log);
            TextView textView2 = new TextView(this);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView2.setText("Hi Nick! I am " + status.toLowerCase() +" rn. \nWant to join me? ");
            textView2.setTextColor(getResources().getColor(R.color.colorPrimary));
            textView2.setTextSize(20);
            textView2.setGravity(Gravity.LEFT);
            //left, top, right, bottom
            textView2.setPadding(10, 0, 0, 0);
            linearLayout.addView(textView2);

        }
    }
}
