package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent =getIntent();

        String name = intent.getStringExtra("name");
        Date startDate = (Date) intent.getSerializableExtra("start");
        Date endDate = (Date) intent.getSerializableExtra("end");
        String location = intent.getStringExtra("location");;
        String details = intent.getStringExtra("details");;
        int imageResource = intent.getIntExtra("image", 0);
        final ArrayList<Person> attendees = (ArrayList<Person>) intent.getSerializableExtra("attendees");

        ((TextView)findViewById(R.id.activity_event_details_name)).setText(name);
        ((TextView)findViewById(R.id.activity_event_details_date)).setText(startDate.toString()+ " - " + endDate.toString());
        ((TextView)findViewById(R.id.activity_event_details_location)).setText(location);
        ((TextView)findViewById(R.id.activity_event_details_details)).setText(details);
        ((TextView)findViewById(R.id.activity_event_details_time)).setText("N/A");
        ((ImageView)findViewById(R.id.activity_event_details_image)).setImageResource(imageResource);


        //GridLayout gridLayout =  ((GridLayout) findViewById(R.id.activity_event_details_attending_list));
        LinearLayout gallery = findViewById(R.id.gallery);
        LayoutInflater inflater = LayoutInflater.from(this);

        //do a for loop for every person attending
        for (int i = 0; i < attendees.size(); i++) {
            View view = inflater.inflate(R.layout.people_attending, gallery, false);

            // ImageView circleImageView = ((ImageView) getLayoutInflater().inflate(R.layout.people_attending));
            ImageView circleImageView = view.findViewById(R.id.imageView);
            final Person person = attendees.get(i);

            circleImageView.setImageResource(person.getmResourceImage());
            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EventDetails.this, Chat.class);

                    intent.putExtra("name", person.getmName());
                    intent.putExtra("image", person.getmResourceImage());
                    intent.putExtra("status", person.getmStatus());

                    startActivity(intent);
                }
            });
            gallery.addView(view);
        }

//
      CheckBox checkBox1 = (CheckBox) findViewById(R.id.chip_online);
////        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
////                .getBoolean("checkBox1", false);
//        if (checkBox1.isChecked() == true) {
//            EventItem.stayVisible(true);
//        }
//
//        if ( EventItem.getChecked() == true) {
//            checkBox1.setChecked(true);
//        }

//        // Init
//        SharedPreferences settings = getSharedPreferences("mysettings", 0);
//        SharedPreferences.Editor editor = settings.edit();
//
//        // Save
//        boolean checkBoxValue = checkBox1.isChecked();
//        editor.putBoolean("checkBox1", checkBoxValue);
//        editor.commit();;
//
//        // Load
//        checkBox1.setChecked(settings.getBoolean("checkBox1", false));


    }

    public void loadChat(View view) {
        startActivity(new Intent(EventDetails.this, Chat.class));
    }

    public void loadHomeScreen(View view) {
        startActivity(new Intent(EventDetails.this, Home.class));
    }

    public void loadProfileScreen(View view) {
        startActivity(new Intent(EventDetails.this, Profile.class));
    }
}
