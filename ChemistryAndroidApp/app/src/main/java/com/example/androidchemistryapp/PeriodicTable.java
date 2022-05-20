package com.example.androidchemistryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PeriodicTable extends AppCompatActivity {
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic_table);

        backButton = (Button) findViewById(R.id.backButton);

        // backButton Action Listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish is used because it allows for the user to use the back button in the android system.
                finish();
            }
        });
    }
}