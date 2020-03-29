package com.example.cisc_325_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Person> {

    public FriendsAdapter(Context context, ArrayList<Person> people) {
        super(context, 0, people);
    }

    // Generates the list item for the friends list as the user scrolls
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.friend_item, parent, false);
        }

        Person person = getItem(position);

        // set the status and name of the person for the textView
        TextView textView = (TextView) listItem.findViewById(R.id.status);
        textView.setText(person.getmStatus());

        textView = (TextView) listItem.findViewById(R.id.name);
        textView.setText(person.getmName());

        // set the profile picture of the person
        ImageView imageView = (ImageView) listItem.findViewById(R.id.image);
        if (person.hasImage()) {
            imageView.setImageResource(person.getmResourceImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItem;

    }
}
