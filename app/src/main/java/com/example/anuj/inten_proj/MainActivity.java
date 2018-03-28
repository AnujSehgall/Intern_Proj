package com.example.anuj.inten_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin_age = (Spinner) findViewById(R.id.age);
        Spinner spin_gen = (Spinner) findViewById(R.id.gender);
        // Spinner click listener
        spin_age.setOnItemSelectedListener(this);

        List age_grps = new ArrayList<>();
        age_grps.add("Less than 10 years");
        age_grps.add("10 – 15 years");
        age_grps.add("16 – 40 years");
        age_grps.add("Above 40 years");

        List gen = new ArrayList<>();
        gen.add("MALE");
        gen.add("FEMALE");


        // Creating adapter for spinner
        ArrayAdapter age_adap = new ArrayAdapter (MainActivity.this, android.R.layout.simple_spinner_item, age_grps);
        ArrayAdapter gen_adap = new ArrayAdapter (MainActivity.this, android.R.layout.simple_spinner_item,gen );

// Drop down layout style - list view with radio button
        age_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gen_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// attaching data adapter to spinner
        spin_age.setAdapter(age_adap);
        spin_gen.setAdapter(gen_adap);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
