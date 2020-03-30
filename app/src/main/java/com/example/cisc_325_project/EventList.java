package com.example.cisc_325_project;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.example.cisc_325_project.ChangeEventList.getEvents;
import static com.example.cisc_325_project.R.id.activity_events_list;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventList extends Fragment {
    private ArrayList<EventItem> events;
    EventAdapter eventAdapter;
    public EventList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        {

            events = ChangeEventList.getEvents();
            eventAdapter = new EventAdapter(this.getContext(), events);
            ListView listView =  getView().findViewById(activity_events_list);

            listView.setAdapter(eventAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), EventDetails.class);
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

        // give the 'create new event' button an onClick listener
        Button button = (Button) getView().findViewById(R.id.button_create_event);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreateEvent.class));
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        eventAdapter.notifyDataSetChanged();
    }



}
