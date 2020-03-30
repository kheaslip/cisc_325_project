package com.example.cisc_325_project;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsList extends Fragment {

    private ArrayList<Person> mPeople;
    private FriendsAdapter mFriendsAdapter;
    private EditText Name;
    private String name;
    private EditText statusperson;
    private String Statusperson;


    public FriendsList() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        // get the list of friends
        mPeople = PeopleList.getFriends();

        View rootView = inflater.inflate(R.layout.fragment_friends_list, container, false);
        mFriendsAdapter = new FriendsAdapter(this.getContext(), mPeople);

        ListView listView = (ListView) rootView.findViewById(R.id.friend_list);
        listView.setAdapter(mFriendsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), Chat.class);
                Person person = mPeople.get(position);

                intent.putExtra("name", person.getmName());
                intent.putExtra("image", person.getmResourceImage());
                intent.putExtra("status", person.getmStatus());

                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void addFriend (String Name, int image, String status){
           mPeople.add(new Person(Name, image, status));
    }

    //once AddContact calls this class, the adapter will be notified that there is new person
    //and should show that person
    public void notifyAdapter () {
        mFriendsAdapter.notifyDataSetChanged();

    }
}
