package com.example.anuj.inten_proj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Interest_Act extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CheckBox Swimming, Running, Football, Rugby, Dance;
    Button btn;
    String v = "V:0", w="W:0", x= "X:0", y="Y:0",z="Z:0",res,fkey,training,pqrs,abcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_);


        training= getIntent().getStringExtra("ab");
        //Toast.makeText(getApplicationContext(),training,Toast.LENGTH_SHORT).show();

        Spinner spin_train = (Spinner) findViewById(R.id.train);
        Spinner spin_excer = (Spinner) findViewById(R.id.excer);
        btn = findViewById(R.id.nxt2qr);
        Swimming = findViewById(R.id.checkBox1);
        Running = findViewById(R.id.checkBox2);
        Football = findViewById(R.id.checkBox3);
        Rugby = findViewById(R.id.checkBox4);
        Dance =findViewById(R.id.checkBox5);


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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ProgressDialog dialog = ProgressDialog.show(Interest_Act.this, "", "Loading. Please wait...", true);
                    res = strGen();
                    Intent intent = new Intent(Interest_Act.this,QR_Act.class);
                   // Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
                    intent.putExtra("key", res);
                    startActivity(intent);
                    finish();
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.train:
                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                switch (training){
                    case "fem":
                    switch (position) {
                        case 0:
                            abcd = "A:1 B:0 C:0 D:0";
                            break;
                        case 1:
                            abcd = "A:0 B:1 C:0 D:0";
                            break;
                        case 2:
                            abcd = "A:0 B:0 C:1 D:0";
                            break;
                        case 3:
                            abcd = "A:0 B:0 C:0 D:1";
                            break;
                    }
                    break;

                    case "mal":
                    switch (position){
                        case 0: abcd = "A:2 B:0 C:0 D:0";
                            break;
                        case 1: abcd = "A:0 B:2 C:0 D:0";
                            break;
                        case 2: abcd = "A:0 B:0 C:2 D:0";
                            break;
                        case 3: abcd = "A:0 B:0 C:0 D:2";
                            break;
                    }
                    break;
                    default:
                        break;
                }
                break;
            case R.id.excer:
                String item2 = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), "Selected: " + item2, Toast.LENGTH_LONG).show();
                switch (position){
                    case 0: pqrs = "P:1 Q:0 R:0 S:0";
                    break;
                    case 1: pqrs = "P:0 Q:1 R:0 S:0";
                    break;
                    case 2: pqrs = "P:0 Q:0 R:1 S:0";
                    break;
                    case 3: pqrs = "P:0 Q:0 R:0 S:1";
                    break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public String strGen(){

        String name,key;
        name = getIntent().getStringExtra("name");
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        key = String.format("%05d", num);

        if (Swimming.isChecked()){
            v = " V:1 ";
        }
        if (Running.isChecked()){
            w = "W:1 ";
        }
        if (Football.isChecked()){
            x = " X:1 ";
        }
        if (Rugby.isChecked()){
            y = " Y:1 ";
        }
        if (Dance.isChecked()){
            z = "Z:1 ";
        }

        fkey = name+key+" "+abcd+" "+pqrs+" "+v+w+x+y+z;


        return fkey;
    }
}
