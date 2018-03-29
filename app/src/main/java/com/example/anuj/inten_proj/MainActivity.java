package com.example.anuj.inten_proj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String item,item2,tr,name;
    EditText edname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin_age = (Spinner) findViewById(R.id.age);
        Spinner spin_gen = (Spinner) findViewById(R.id.gender);
        Button nxt =(Button) findViewById(R.id.nxt);
        edname= findViewById(R.id.namelay);

        spin_age.setOnItemSelectedListener(this);
        spin_gen.setOnItemSelectedListener(this);

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

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edname.getText().toString();
                if (name.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                }
                else {
                    String nname = name.substring(0, 2);
                    Intent i = new Intent(MainActivity.this,Interest_Act.class);
                    i.putExtra("name", nname);
                    i.putExtra("ab",tr);
                    startActivity(i);
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.age:
                item = parent.getItemAtPosition(position).toString();
               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                break;
            case R.id.gender:
                item2 = parent.getItemAtPosition(position).toString();
             //   Toast.makeText(parent.getContext(), "Selected: " + item2, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        if (item == "Less than 10 years" || item == "10 – 15 years" || item2 =="FEMALE"){

            tr="fem";
        }
        else if ((item == "16 – 40 years" || item == "Above 40 years") && item2 =="MALE"){

            tr="mal";
        }

        else
            tr="fem";
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
