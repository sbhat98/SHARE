package edu.gatech.hackgt.effishare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Rentee_Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentee__request);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String owner = i.getStringExtra("owner");
        String description = i.getStringExtra("description");
        double securityDepositValue = i.getDoubleExtra("securityDepositValue", 0);
        boolean checkedOut = i.getBooleanExtra("checkedOut", true);
        String itemPhotoURL = i.getStringExtra("itemPhotoURL");

        //Item i = new Item(name, owner, description, securityDepositValue, checkedOut, itemPhotoURL);
//        i.setID(3);


    }
}
