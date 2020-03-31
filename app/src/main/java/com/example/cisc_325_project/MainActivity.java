package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editText9);
        Password = findViewById(R.id.editText10);
        Login = findViewById(R.id.button);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    public void validate(String username, String password){
        if(username.matches("")){ // if the username field is left empty
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.matches("")){ // if the password field is left empty
            Toast.makeText(this, "You did not enter a password", Toast.LENGTH_SHORT).show();
            return;
        }
        if((username.equals("firstyear@queensu.ca")) && (password.equals("2023"))){
            startActivity(new Intent(this, Home.class)); //when the right password/username is entered go to the next activity
        }
        else{
            wrongEntryError();
        }
    }

    private void wrongEntryError() {
        Password.setError("Password and/or username were incorrect");
    }
}
