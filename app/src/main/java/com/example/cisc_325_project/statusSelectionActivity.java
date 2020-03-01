package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class statusSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_selection);

        if (Home.hasStatus()) {
            ((EditText)findViewById(R.id.change_status)).setText(Home.getmStatus());
        }

        final Button updateStatusButton = (Button) findViewById(R.id.confirm_status_button);
        EditText editText = (EditText) findViewById(R.id.change_status);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateStatusButton.setVisibility(View.VISIBLE);
            }
        });
    }


    public void updateStatus(View view) {
        ((TextView) findViewById(R.id.change_status)).setText(((TextView) view).getText());
    }
}
