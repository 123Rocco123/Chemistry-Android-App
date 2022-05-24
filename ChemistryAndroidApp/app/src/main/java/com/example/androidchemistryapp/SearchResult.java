package com.example.androidchemistryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SearchResult extends AppCompatActivity {
    String elementOrCompound = "";

    TextView title;
    TextView elementFormula;
    TextView meltingPoint;
    TextView boilingPoint;
    TextView electronConfiguration;
    TextView charge;
    TextView atomicMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Used to remove top bar from page
        getSupportActionBar().hide();

        title = (TextView) findViewById(R.id.title);
        elementFormula = (TextView) findViewById(R.id.elementFormula);
        meltingPoint = (TextView) findViewById(R.id.meltingPointText);
        boilingPoint = (TextView) findViewById(R.id.boilingPoint);
        electronConfiguration = (TextView) findViewById(R.id.electronConfiguration);
        charge = (TextView) findViewById(R.id.charge);
        atomicMass = (TextView) findViewById(R.id.atomicMass);

        // New Page Setup
        Intent recievedIntent = getIntent();

        setterFunc(recievedIntent.getStringExtra("compoundName"), recievedIntent.getStringExtra("0"), recievedIntent.getStringExtra("1"), recievedIntent.getStringExtra("2"), recievedIntent.getStringExtra("3"), recievedIntent.getStringExtra("4"), recievedIntent.getStringExtra("5"));
    }

    public void setterFunc(String newTitle, String newElementFormula, String newMeltingPoint, String newBoilingPoint, String electronConfig, String Charge, String AtomicMass) {
        title.setText(newTitle);
        elementFormula.setText(newElementFormula);
        meltingPoint.setText(newMeltingPoint);
        boilingPoint.setText(newBoilingPoint);
        electronConfiguration.setText(electronConfig);
        charge.setText(Charge);
        atomicMass.setText(AtomicMass);
    }
}