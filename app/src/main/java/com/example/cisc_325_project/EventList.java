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

import static com.example.cisc_325_project.R.id.activity_events_list;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventList extends Fragment {

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

        // setup list of events
        {
            final ArrayList<EventItem> events = new ArrayList<EventItem>();
            final ArrayList<Person> people = PeopleList.getStrangers();

            events.add(new EventItem("Canada Day Firework Show",
                    new Date(2020, 6, 1, 21,0,0),
                    new Date(2020, 6, 1, 22,0,0),
                    "Kingston",
                    "The annual fireworks display for Canada day",
                    R.drawable.event_image_fireworks,
                    new ArrayList<>(Arrays.asList(
                            people.get(0), people.get(1), people.get(2), people.get(3)
                    ))));

            events.add(new EventItem("Local band tour",
                    new Date(2020, 3, 21, 20,0,0),
                    new Date(2020, 3, 21, 23,0,0),
                    "Kingston",
                    "Several local bands playing this weekend",
                    R.drawable.event_image_concert,
                    new ArrayList<>(Arrays.asList(
                            people.get(4), people.get(7), people.get(2), people.get(0)
                    ))));

            events.add(new EventItem("Orientation Week",
                    new Date(2020, 9, 1, 8,0,0),
                    new Date(2020, 12, 1, 23,0,0),
                    "Kingston",
                    "Join your new classmates as we play games.",
                    R.drawable.event_image_crowd_1,
                    new ArrayList<>(Arrays.asList(
                            people.get(4), people.get(2), people.get(5), people.get(1)
                    ))));

            events.add(new EventItem("Karaoke",
                    new Date(2020, 3, 14, 20,0,0),
                    new Date(2020, 3, 14, 23,0,0),
                    "Kingston",
                    "Weekly karaoke night where you and your friends can battle-off.",
                    R.drawable.event_image_karaoke,
                    new ArrayList<>(Arrays.asList(
                            people.get(4), people.get(7), people.get(2), people.get(0), people.get(5),
                            people.get(1), people.get(6), people.get(3)
                    ))));



            EventAdapter eventAdapter = new EventAdapter(this.getContext(), events);
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


}
