package com.example.cisc_325_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ChangeEventList {


    static private ArrayList<EventItem> events = new ArrayList<EventItem>();
    static private ArrayList<Person> people = PeopleList.getStrangers();

    //add the events
    static {
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
    }

    public ChangeEventList(){

    }

    static public void addEvent(String name, int year, int month, int day, int hour, int min,
                                int endyear,  int endmonth, int endday, int endhour, int endmin, String Location, String details, int image ) {
        events.add(new EventItem(name,
                new Date(year, month, day, hour, min,0),
                new Date(endyear, endmonth, endday, endhour,endmin,0),
                Location,
                details,
                image,
                new ArrayList<>(Arrays.asList(
                        people.get(4), people.get(7), people.get(2)
                ))));
    }

    /**
     * Returns a reference to the list of friends
     * @return a reference to the list of friends
     */
    static public ArrayList<EventItem> getEvents() {
        return events;
    }
}
