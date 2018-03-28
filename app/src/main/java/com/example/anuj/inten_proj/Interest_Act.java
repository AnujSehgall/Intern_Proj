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

public class Interest_Act extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_);

        Spinner spin_train = (Spinner) findViewById(R.id.train);
        Spinner spin_excer = (Spinner) findViewById(R.id.excer);


        spin_train.setOnItemSelectedListener(this);
        spin_excer.setOnItemSelectedListener(this);

        List train_lst = new ArrayList<>();
        train_lst.add("Maui Thai");
        train_lst.add("Jujutsu,");
        train_lst.add("Karate");
        train_lst.add("Judo");

        List excer_lst = new ArrayList<>();
        excer_lst.add("Cardio");
        excer_lst.add("Strength");
        excer_lst.add("Stamina");
        excer_lst.add("Muscle");

        ArrayAdapter train_adap = new ArrayAdapter (Interest_Act.this, android.R.layout.simple_spinner_item, train_lst);
        ArrayAdapter excer_adap = new ArrayAdapter (Interest_Act.this, android.R.layout.simple_spinner_item,excer_lst);

        train_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        excer_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_train.setAdapter(train_adap);
        spin_excer.setAdapter(excer_adap);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.train:
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                break;
            case R.id.excer:
                String item2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + item2, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
