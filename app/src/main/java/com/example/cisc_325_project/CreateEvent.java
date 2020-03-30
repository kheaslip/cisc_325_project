package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEvent extends AppCompatActivity {
    String date;
    String name;
    String Location;
    String details;
    int year;
    int endyear;
    int month;
    int endMonth;
    int day;
    int endday;
    int startHour;
    int startMin;
    int endHour;
    int endMin;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

    public String getName() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_name);
        if (editText == null) {
            return "";
        } else {
            return editText.getText().toString();
        }
    }

    public String getLocation() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_location);
        if (editText == null) {
            return "";
        } else {
            return editText.getText().toString();
        }
    }

    public String getDetails() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_details);
        if (editText == null) {
            return "";
        } else {
            return editText.getText().toString();
        }
    }
    public int getStartYear() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_start_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            year = Integer.parseInt(date.substring(0, 2));
        }
        return year;
    }

    public int getStartMonth() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_start_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            month= Integer.parseInt(date.substring(2,4));
        }
        return month;
    }

    public int getStartDay() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_start_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            day= Integer.parseInt(date.substring(4,6));
        }
        return day;
    }

    public int getEndYear() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_end_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            endyear= Integer.parseInt(date.substring(0,2));
        }
        return endyear;
    }
    public int getEndMonth() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_end_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            endMonth= Integer.parseInt(date.substring(0,2));
        }
        return endMonth;
    }

    public int getEndday() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_end_date);
        if (editText == null || editText.length() < 6) {
            return 0;
        } else {
            date = editText.getText().toString();
            endday= Integer.parseInt(date.substring(0,2));
        }
        return endday;
    }

    public int getStartHour() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_start_time);
        if (editText == null || editText.length() < 4) {
            return 0;
        } else {
            date = editText.getText().toString();
            startHour= Integer.parseInt(date.substring(0,2));
        }
        return startHour;


    }

    public int getEndHour() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_end_time);
        if (editText == null || editText.length() < 4) {
            return 0;
        } else {
            date = editText.getText().toString();
            endHour = Integer.parseInt(date.substring(0, 2));
        }
        return endHour;

    }
    public int getStartMin() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_start_time);
        if (editText == null || editText.length() < 4) {
            return 0;
        } else {
            date = editText.getText().toString();
            startMin= Integer.parseInt(date.substring(2,4));
        }
        return startMin;
    }

    public int getEndMin() {
        EditText editText = (EditText) findViewById(R.id.activity_create_event_end_time);
        if (editText == null || editText.length() < 4) {
            return 0;
        } else {
            date = editText.getText().toString();
            endMin= Integer.parseInt(date.substring(2,4));
        }
        return endMin;
    }




    public void createEventButton(View view) {
        name = getName();
        year = getStartYear();
        month = getStartMonth();
        day = getStartDay();
        endyear = getEndYear();
        endMonth = getEndMonth();
        endday = getEndday();
        startHour = getStartHour();
        startMin=getStartMin();
        endHour = getEndHour();
        endMin = getEndMin();
        Location = getLocation();
        details = getDetails();

        ChangeEventList.addEvent(name, year, month, day,  startHour, startMin,
        endyear,  endMonth, endday, endHour, endMin, Location, details,  R.drawable.ic_launcher_background);
        startActivity(new Intent(CreateEvent.this, Home.class));


    }
}
