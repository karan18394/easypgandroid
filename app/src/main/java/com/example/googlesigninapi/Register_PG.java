package com.example.googlesigninapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Register_PG extends AppCompatActivity {

    private TextView et1, et2,et3,et4, et12, et5,et6,et7,et8,et9,et10,et11;
    private RadioButton ac, wifi,geyser, food,parking,security;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pg);

        Button submit = (Button) findViewById(R.id.submit);

        et1 = (TextView) findViewById(R.id.et1);
        et2 = (TextView) findViewById(R.id.et2);
        et3 = (TextView) findViewById(R.id.et3);
        et4 = (TextView) findViewById(R.id.et4);
        et5 = (TextView) findViewById(R.id.et5);
        et6 = (TextView) findViewById(R.id.et6);
        et7 = (TextView) findViewById(R.id.et7);
        et8 = (TextView) findViewById(R.id.et8);
        et9 = (TextView) findViewById(R.id.et9);
        et10 = (TextView) findViewById(R.id.et10);
        et11 = (TextView) findViewById(R.id.et11);
        et12 = (TextView) findViewById(R.id.et12);
        ac = (RadioButton) findViewById(R.id.ac);
        wifi = (RadioButton) findViewById(R.id.wifi);
        parking = (RadioButton) findViewById(R.id.parking);
        geyser = (RadioButton) findViewById(R.id.geyser);
        security = (RadioButton) findViewById(R.id.security);
        food = (RadioButton) findViewById(R.id.food);

        Log.d("Reached1", "Here");

    }


    public void onClickSubmit(View view) {

        DatabaseReference reference = MainActivity.database.getReference("PGInformation");

        Log.d("Reached", "Here");
        PG pg = new PG();
        pg.setPgName(et1.getText().toString());
        pg.setOwnerName(et2.getText().toString());
        pg.setPhoneNumber(et3.getText().toString());
        pg.setPgemailID(et4.getText().toString());
        pg.setNumberOfRooms(et12.getText().toString());
        pg.setCity(et5.getText().toString());

        Log.d("Data", "successful");

        pg.setAddress(et6.getText().toString());
        pg.setLongitude(et7.getText().toString());
        pg.setLatitude(et8.getText().toString());
        pg.setSingleSharingRent(Integer.parseInt(et9.getText().toString()));
        pg.setDoubleSharingRent(Integer.parseInt(et10.getText().toString()));
        pg.setTripleSharingRent(Integer.parseInt(et11.getText().toString()));

        pg.setWifiAvailable(wifi.isChecked());
        pg.setGeyserAvailable(geyser.isChecked());
        pg.setParkingAvailable(parking.isChecked());
        pg.setSecurityAvailable(security.isChecked());
        pg.setACAvailable(ac.isChecked());

        pg.setPgID(pg.getPgID());

        Log.d("Data", "successful");

        reference.child("PG").child(pg.getPgID()).setValue(pg);


        /*AlertDialog builder1 = new AlertDialog.Builder(Register_PG.this)
                .setTitle("DATA ADDED SUCCESSFULLY")
                .setMessage("Click OK to continue...")
                .setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }).create();
        builder1.show();*/
    }
}