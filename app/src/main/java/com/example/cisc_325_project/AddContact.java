package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    /**
     * Gets the text within the EditText element that holds the person's name
     * @return the text in the element, or "" if no element found
     */
    public String getName() {
        EditText editText = (EditText) findViewById(R.id.editText);
        if (editText == null) {
            return "";
        } else {
            return editText.getText().toString();
        }
    }

    public void createFriendButton(View view) {
        String name = getName();
        if (name != null && !name.equals("")) {
            PeopleList.addFriend(name);
            ((EditText) findViewById(R.id.editText)).setText("");
            ((EditText) findViewById(R.id.editText2)).setText("");
        }
        startActivity(new Intent(AddContact.this, Home.class));
    }

}
