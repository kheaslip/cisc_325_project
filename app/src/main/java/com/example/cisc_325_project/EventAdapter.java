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

public class EventAdapter extends ArrayAdapter<EventItem> {

    public EventAdapter(Context context, ArrayList<EventItem> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_list_item, parent, false);
        }

        EventItem eventItem = getItem(position);

        // set the status and name of the person for the textView
        TextView textView = (TextView) listItem.findViewById(R.id.event_list_item_name);
        textView.setText(eventItem.getmName());

        textView = (TextView) listItem.findViewById(R.id.event_list_item_details);
        textView.setText(eventItem.getmDetails());

        // set the profile picture of the person
        ImageView imageView = (ImageView) listItem.findViewById(R.id.event_list_item_image);
        if (eventItem.hasImage()) {
            imageView.setImageResource(eventItem.getmImageResource());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // TODO: add attendee list

        return listItem;
    }
}
