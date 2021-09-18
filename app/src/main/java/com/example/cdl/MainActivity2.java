package com.example.cdl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    Button bt3;

    EditText edtload;
    EditText edton;
    EditText edtoff;

    static String LoadUrl = "";
    static String Urlon = "";
    static String Urloff = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt3 = (Button) findViewById(R.id.button3);

        edtload = findViewById(R.id.editTextTextPersonName3);
        edton = findViewById(R.id.editTextTextPersonName);
        edtoff = findViewById(R.id.editTextTextPersonName2);


        readLoadUrl();
        readUrlon();
        readUrloff();

        edtload.setText(LoadUrl);
        edton.setText(Urlon);
        edtoff.setText(Urloff);

        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                LoadUrl = edtload.getText().toString();
                Urlon = edton.getText().toString();
                Urloff = edtoff.getText().toString();
                saveLoadUrl();
                saveUrlon();
                saveUrloff();
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });




    }


    private void readLoadUrl() {
        SharedPreferences sharedPreferences = getSharedPreferences("readLoadUrl", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readLoadUrl", "");
        if (var != "") {
            LoadUrl = var;
        }
    }
    private void saveLoadUrl() {
        SharedPreferences sharedPreferences = getSharedPreferences("readLoadUrl", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("readLoadUrl", LoadUrl);
        editor.commit();
    }

    private void readUrlon() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrlon", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readUrlon", "");
        if (var != "") {
            Urlon = var;
        }
    }
    private void saveUrlon() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrlon", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("readUrlon", Urlon);
        editor.commit();
    }

    private void readUrloff() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrloff", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readUrloff", "");
        if (var != "") {
            Urloff = var;
        }
    }
    private void saveUrloff() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrloff", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("readUrloff", Urloff);
        editor.commit();
    }


}