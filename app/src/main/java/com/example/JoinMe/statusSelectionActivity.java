package com.example.JoinMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cisc_325_project.R;

public class statusSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_selection);

        if (Home.hasStatus()) {
            ((EditText)findViewById(R.id.change_status)).setText(Home.getmStatus());
        }

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
                findViewById(R.id.confirm_status_button).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Home.hasStatus()) {
            ((EditText)findViewById(R.id.change_status)).setText(Home.getmStatus());
        }
    }

    public void replaceStatusText(View view) {
        ((TextView) findViewById(R.id.change_status)).setText(((TextView) view).getText());
    }

    public void confirmStatusChange(View view) {
        String newStatus = ((TextView)findViewById(R.id.change_status)).getText().toString();
        Home.setmStatus(newStatus);
        findViewById(R.id.confirm_status_button).setVisibility(View.GONE);
        startActivity(new Intent(statusSelectionActivity.this, Home.class));
    }
}
