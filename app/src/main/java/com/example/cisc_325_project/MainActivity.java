package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("Sasha Beltran", R.drawable.profile_woman_1, "At the gym"));
        people.add(new Person("Harmony Bennett", R.drawable.profile_woman_2, "Studying"));
        people.add(new Person("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall"));
        people.add(new Person("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball"));

        people.add(new Person("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall"));
        people.add(new Person("Mikhail Sanderson",R.drawable.profile_man_2,"Studying"));
        people.add(new Person("Blessing Baldwin",R.drawable.profile_man_3,"At conference"));
        people.add(new Person("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go"));

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
