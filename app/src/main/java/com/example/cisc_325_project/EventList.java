package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EventList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        final ArrayList<EventItem> events = new ArrayList<EventItem>();
        final ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("Sasha Beltran", R.drawable.profile_woman_1, "At the gym"));
        people.add(new Person("Harmony Bennett", R.drawable.profile_woman_2, "Studying"));
        people.add(new Person("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall"));
        people.add(new Person("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball"));

        people.add(new Person("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall"));
        people.add(new Person("Mikhail Sanderson",R.drawable.profile_man_2,"Studying"));
        people.add(new Person("Blessing Baldwin",R.drawable.profile_man_3,"At conference"));
        people.add(new Person("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go"));

        events.add(new EventItem("Canada Day Firework Show",
                new Date(2020, 6, 1, 21,0,0),
                new Date(2020, 6, 1, 22,0,0),
                "Kingston",
                "The annual fireworks display for Canada day",
                R.drawable.event_image_fireworks,
                new ArrayList<>(Arrays.asList(
                        people.get(0), people.get(1), people.get(2), people.get(3)
                ))));

        events.add(new EventItem("Local band tour",
                new Date(2020, 3, 21, 20,0,0),
                new Date(2020, 3, 21, 23,0,0),
                "Kingston",
                "Several local bands playing this weekend",
                R.drawable.event_image_concert,
                new ArrayList<>(Arrays.asList(
                        people.get(4), people.get(7), people.get(2), people.get(0)
                ))));

        events.add(new EventItem("Orientation Week",
                new Date(2020, 9, 1, 8,0,0),
                new Date(2020, 12, 1, 23,0,0),
                "Kingston",
                "Join your new classmates as we play games.",
                R.drawable.event_image_crowd_1,
                new ArrayList<>(Arrays.asList(
                        people.get(4), people.get(2), people.get(5), people.get(1)
                ))));

        events.add(new EventItem("Karaoke",
                new Date(2020, 3, 14, 20,0,0),
                new Date(2020, 3, 14, 23,0,0),
                "Kingston",
                "Weekly karaoke night where you and your friends can battle-off.",
                R.drawable.event_image_karaoke,
                new ArrayList<>(Arrays.asList(
                        people.get(4), people.get(7), people.get(2), people.get(0), people.get(5),
                        people.get(1), people.get(6), people.get(3)
                ))));



        EventAdapter eventAdapter = new EventAdapter(this.getBaseContext(), events);
        ListView listView = (ListView) findViewById(R.id.activity_events_list);

        listView.setAdapter(eventAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EventDetails.class);
                EventItem eventItem = events.get(position);

                intent.putExtra("name", eventItem.getmName());
                intent.putExtra("start", eventItem.getmStartDate());
                intent.putExtra("end", eventItem.getmEndDate());
                intent.putExtra("location", eventItem.getmLocation());
                intent.putExtra("details", eventItem.getmDetails());
                intent.putExtra("image", eventItem.getmImageResource());
                intent.putExtra("attendees", eventItem.getmAttendees());

                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Home.hasStatus()) {
            ((Button)findViewById(R.id.status_button)).setText(Home.getmStatus());
        }
    }

    public void loadEventCreationScreen(View view) {
        startActivity(new Intent(EventList.this, CreateEvent.class));
    }

    public void loadStatusScreen(View view) {
        startActivity(new Intent(EventList.this, statusSelectionActivity.class));
    }

    public void loadHomeScreen(View view) {
        startActivity(new Intent(EventList.this, Home.class));
    }

    public void loadProfileScreen(View view) {
        startActivity(new Intent(EventList.this, Profile.class));
    }
}
