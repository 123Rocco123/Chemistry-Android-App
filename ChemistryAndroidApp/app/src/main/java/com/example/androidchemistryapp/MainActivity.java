package com.example.androidchemistryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Contains the name of the Element
    String name;

    // Contains the input field
    EditText nameInput;

    // Contains the button
    Button submitButton;

    private void popUpMessage(String elementToSearch) {
        // The "Toast.LENGTH_SHORT" is used to determine the duration that the pop-up message stays on screen for.
        Toast.makeText(MainActivity.this, ("Searching Element: " + elementToSearch), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.nameInput);
        submitButton = (Button) findViewById(R.id.submitButton);

        // Similar to the "addActionListener" in Swing
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (nameInput.getText()).toString();

                popUpMessage(name);
            }
        });
    }
}