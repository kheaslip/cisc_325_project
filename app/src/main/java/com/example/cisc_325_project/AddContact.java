package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    private EditText Name;
    private String name;
    private EditText statusperson;
    private String Statusperson;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


        //I tried to follow a video here to make it work but it just gave me a blank screen


//        Name = (EditText) findViewById(R.id.editText);
//        statusperson = (EditText) findViewById(R.id.editText2);
//        name = Name.getText().toString();
//        Statusperson = statusperson.getText().toString();

//        ListView listView = (ListView) findViewById(R.id.friend_list);
//        initialize();
//        fAdapter = new FriendsAdapter(AddContact.this, people);
//        listView.setAdapter(fAdapter);
//        Name = (EditText) findViewById(R.id.editText);
//        statusperson = (EditText) findViewById(R.id.editText2);
//        Button btAdd = (Button) findViewById(R.id.button_add_friend);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                name = Name.getText().toString();
//                Statusperson = statusperson.getText().toString();
//                addFriend(name, R.drawable.ic_launcher_background, Statusperson);
//                fAdapter.notifyDataSetChanged();
//
//            }
//        });


    }



    public String getName() {
        Name = (EditText) findViewById(R.id.editText);
        name = Name.getText().toString();
        return name;
    }

    public String getStatus() {
        statusperson = (EditText) findViewById(R.id.editText2);
        Statusperson = statusperson.getText().toString();
        return Statusperson;
    }

    public void createFriendButton(View view) {

        name = getName();
        Statusperson = getStatus();
        FriendsList A = new FriendsList();
        //name and status of person work; it gets the correct values
        A.addFriend(name, R.drawable.ic_launcher_background, Statusperson);
        //im not sure what happens here, there must be an error happening
        A.notifyAdapter();


        startActivity(new Intent(AddContact.this, Home.class));
    }

}
