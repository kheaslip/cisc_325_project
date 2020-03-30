package com.example.cisc_325_project;

import java.util.ArrayList;

public class PeopleList {

    static private ArrayList<Person> mExisitingFriends = new ArrayList<Person>(0);
    static private ArrayList<Person> mStrangers = new ArrayList<Person>(0);

    // add the people
    static {
        addFriend ("Sasha Beltran", "Going for a walk", R.drawable.profile_woman_1, 44.229444, -76.494350);
        addFriend ("Harmony Bennett", "Studying", R.drawable.profile_woman_2, 44.225361, -76.498782);
        addFriend ("Tori Mcbride", "At the dinning hall", R.drawable.profile_woman_3,  44.224681, -76.496035);
        addFriend ("Saniya Hodson", "Playing basketball", R.drawable.profile_woman_4,  44.229316, -76.494139);

        addFriend ("Colin Woodard", "At the dinning hall", R.drawable.profile_man_1, 44.224096, -76.500638);
        addFriend ("Mikhail Sanderson", "Studying", R.drawable.profile_man_2, 44.227311, -76.495121);
        addFriend ("Blessing Baldwin", "At conference", R.drawable.profile_man_3, 44.218255, -76.517759);
        addFriend ("Zacharias Phelps", "Playing Go", R.drawable.profile_man_4, 44.194878, -76.438305);

        addPerson(mStrangers, new Person("Charlie Jum", R.drawable.profile_woman_5, "At the gym"));
        addPerson(mStrangers, new Person("Alexa Vian", R.drawable.profile_woman_6, "Studying"));
        addPerson(mStrangers, new Person("Peter Pawm", R.drawable.profile_man_7, "At the dinning hall"));
        addPerson(mStrangers, new Person("Soni Iman", R.drawable.profile_man_8, "Playing basketball"));
        addPerson(mStrangers, new Person("Chris Pomlan",R.drawable.profile_man_9,"At the dinning hall"));
        addPerson(mStrangers, new Person("Micheal Port",R.drawable.profile_man_6,"Studying"));
        addPerson(mStrangers, new Person("Bob Marlawn",R.drawable.profile_man_10,"At conference"));
        addPerson(mStrangers, new Person("Zoe Chres",R.drawable.profile_woman_7,"Playing Go"));
    }

    public PeopleList() {

    }

    /**
     * Adds the given friend based on the arguments.
     * If the name is in the list of strangers, then moves that person from
     * the stranger list to the friend list.  Else, creates a new person from
     * the parameters.
     * @param name the name of the new friend
     * @param status the new friends status
     * @param imageResource the android image resource id
     * @param latitude the latitude of the person
     * @param longitude the longitude of the person
     */
    static public void addFriend(String name, String status, int imageResource,
                          double latitude, double longitude) {
        if (name == null) {name = "";}
        if (status == null) {status = "";}

        Person newFriend = removeStranger(name);

        if (newFriend == null) {
            addPerson(mExisitingFriends,
                    new Person(name, imageResource, status, latitude, longitude));
        } else {
            addPerson(mExisitingFriends, newFriend);
        }
    }

    /**
     * Adds the given friend based on the arguments.
     * If the name is in the list of strangers, then moves that person from
     * the stranger list to the friend list.  Else, creates a new person from
     * the parameters.
     * @param name the name of the new friend
     * @param status the new friends status
     * @param imageResource the android image resource id
     */
    static public void addFriend(String name, String status, int imageResource) {
        addFriend(name, status, imageResource, 0, 0);
    }

    /**
     * Adds the given friend based on the arguments.
     * If the name is in the list of strangers, then moves that person from
     * the stranger list to the friend list.  Else, creates a new person from
     * the parameters.
     * @param name the name of the new friend
     * @param status the new friends status
     */
    static public void addFriend(String name, String status) {
        addFriend(name, status, R.drawable.ic_launcher_background, 0, 0);
    }

    /**
     * Adds the given friend based on the arguments.
     * If the name is in the list of strangers, then moves that person from
     * the stranger list to the friend list.  Else, creates a new person from
     * the parameters.
     * @param name the name of the new friend
     */
    static public void addFriend(String name) {
        addFriend(name, "Playing hide-and-seek", R.drawable.ic_launcher_background, 0, 0);
    }

    /**
     * Pops the first element of the ArrayList of strangers that matches the given name
     * @param name the name of the person
     * @return the first Person object with the matching name, or null if none found.
     */
    static private Person removeStranger(String name) {
        Person person = null;
        for (Person p: mStrangers) {
            if (p.getmName().equalsIgnoreCase(name)) {
                person = p;
                break;
            }
        }
        mStrangers.remove(person);
        return person;
    }

    /**
     * Adds a Person to the given ArrayList
     * @param arr the list of people
     * @param person the new person
     */
    static private void addPerson(ArrayList<Person> arr, Person person) {
        if (arr != null && person != null) {
            arr.add(person);
        }
    }

    /**
     * Returns a reference to the list of friends
     * @return a reference to the list of friends
     */
    static public ArrayList<Person> getFriends() {
        return mExisitingFriends;
    }

    /**
     * Returns a copy of the list of strangers
     * @return a copy of the list of strangers
     */
    static public ArrayList<Person> getStrangers() {
        return mStrangers;
    }
}
