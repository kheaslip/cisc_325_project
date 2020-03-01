package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

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
                "The annual fireworks display for Canada day",
                R.drawable.event_image_fireworks,
                new ArrayList<>(Arrays.asList(
                        people.get(0), people.get(1), people.get(2), people.get(3)
                ))));

        events.add(new EventItem("Local band tour",
                "Several local bands playing this weekend",
                R.drawable.event_image_concert,
                new ArrayList<>(Arrays.asList(
                        people.get(4), people.get(7), people.get(2), people.get(0)
                ))));

        EventAdapter eventAdapter = new EventAdapter(this.getBaseContext(), events);
        ListView listView = (ListView) findViewById(R.id.activity_events_list);
        listView.setAdapter(eventAdapter);

    }
}
