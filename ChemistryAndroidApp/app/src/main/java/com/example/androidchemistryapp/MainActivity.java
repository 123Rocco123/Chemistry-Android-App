package com.example.androidchemistryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Contains the name of the Element
    String name;

    // Contains the input field
    EditText nameInput;

    // Contains the button
    Button submitButton;
    Button PeriodicTableButton;

    // Elements table
    String[] elementsArray = {"hydrogen"};
    String[][] elementsInformation = {{"Number of Molecules: 1"}};

    private void popUpMessage(String elementToSearch) {
        // The "Toast.LENGTH_SHORT" is used to determine the duration that the pop-up message stays on screen for.
        Toast.makeText(MainActivity.this, ("Searching Element: " + elementToSearch), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        nameInput = (EditText) findViewById(R.id.nameInput);

        submitButton = (Button) findViewById(R.id.submitButton);
        PeriodicTableButton = (Button) findViewById(R.id.PeriodicTableButton);

        // Similar to the "addActionListener" in Swing
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (nameInput.getText()).toString();

                popUpMessage(name);
            }
        });

        // Periodic Table Action Listener
        PeriodicTableButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Intent is used to go from one page to another.
                  // The way that it works is that it takes two arguments, where you are now, and where you wanna go.
                  // We can't just use ".this" because we're inside of the setOnClickListener, therefore, we have to use the "MainActivity.this".
                  // We then just write the name of the class that we wanna go to.
               startActivity(new Intent(MainActivity.this, PeriodicTable.class));
           }
        });
    }
}