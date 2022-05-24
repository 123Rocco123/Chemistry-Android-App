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
    String[][] elementsInfo = {{"H", "-252.2 °C", "-252.9 °C", "1s^1", "+1", "1.00784 u"}};

    private void popUpMessage(String elementToSearch) {
        // The "Toast.LENGTH_SHORT" is used to determine the duration that the pop-up message stays on screen for.
        Toast.makeText(MainActivity.this, ("Searching Element: " + elementToSearch), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Used to remove top bar from page
        getSupportActionBar().hide();

        nameInput = (EditText) findViewById(R.id.nameInput);

        submitButton = (Button) findViewById(R.id.submitButton);
        PeriodicTableButton = (Button) findViewById(R.id.PeriodicTableButton);

        // Similar to the "addActionListener" in Swing
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ((nameInput.getText()).toString()).toLowerCase();

                for (int i = 0; i < elementsArray.length; i++) {
                    // The if statement checks if the element that the user has written is inside of the "elementsArray".
                    if (name.equals(elementsArray[i])) {
                        popUpMessage(name);

                        Intent newIntent = new Intent(MainActivity.this, SearchResult.class);

                        newIntent.putExtra("compoundName", name);
                        newIntent.putExtra("0", elementsInfo[0][0]);
                        newIntent.putExtra("1", elementsInfo[0][1]);
                        newIntent.putExtra("2", elementsInfo[0][2]);
                        newIntent.putExtra("3", elementsInfo[0][3]);
                        newIntent.putExtra("4", elementsInfo[0][4]);
                        newIntent.putExtra("5", elementsInfo[0][5]);

                        startActivity(newIntent);
                    } // Executed once the last element in the length has been reached and doesn't meet the requirement above.
                    else if (i == (elementsArray.length - 1)) {
                        // Popup Message in case of nothing being found
                        Toast.makeText(MainActivity.this, "Nothing Found :(", Toast.LENGTH_SHORT).show();
                    }
                }
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