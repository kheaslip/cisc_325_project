package com.example.cisc_325_project;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsList extends Fragment {
//public class FriendsList extends AppCompatActivity {


    public FriendsList() {
        // Required empty public constructor
    }

    ArrayList<Person>  people  = new ArrayList<Person>();
    FriendsAdapter fAdapter;
    private EditText Name;
    private String name;
    private EditText statusperson;
    private String Statusperson;





    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        initialize();
        View rootView = inflater.inflate(R.layout.fragment_friends_list, container, false);
        fAdapter = new FriendsAdapter(this.getContext(), people);

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


    //put adding primary people in a method
    public void initialize() {
        addFriend ("Sasha Beltran", R.drawable.profile_woman_1, "Going for a walk");
        addFriend ("Harmony Bennett", R.drawable.profile_woman_2, "Studying");
        addFriend ("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall");
        addFriend ("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball");

        addFriend ("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall");
        addFriend ("Mikhail Sanderson",R.drawable.profile_man_2,"Studying");
        addFriend ("Blessing Baldwin",R.drawable.profile_man_3,"At conference");
        addFriend ("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go");
    }
    public void addFriend (String Name, int image, String status){
           people.add(new Person(Name,image, status));
    }

    //once AddContact calls this class, the adapter will be notified that there is new person
    //and should show that person
    public void notifyAdapter () {
        fAdapter.notifyDataSetChanged();

    }
}
