package com.example.cisc_325_project;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsList extends Fragment {


    public FriendsList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("Sasha Beltran", R.drawable.profile_woman_1, "At the gym"));
        people.add(new Person("Harmony Bennett", R.drawable.profile_woman_2, "Studying"));
        people.add(new Person("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall"));
        people.add(new Person("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball"));

        people.add(new Person("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall"));
        people.add(new Person("Mikhail Sanderson",R.drawable.profile_man_2,"Studying"));
        people.add(new Person("Blessing Baldwin",R.drawable.profile_man_3,"At conference"));
        people.add(new Person("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go"));

        View rootView = inflater.inflate(R.layout.fragment_friends_list, container, false);

        FriendsAdapter fAdapter = new FriendsAdapter(this.getContext(), people);

        ListView listView = (ListView) rootView.findViewById(R.id.friend_list);
        listView.setAdapter(fAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), Chat.class);
                Person person = people.get(position);

                intent.putExtra("name", person.getmName());
                intent.putExtra("image", person.getmResourceImage());
                intent.putExtra("status", person.getmStatus());

                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
