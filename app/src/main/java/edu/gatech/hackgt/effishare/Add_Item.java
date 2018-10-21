package edu.gatech.hackgt.effishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Item extends AppCompatActivity {
    private Button addI;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Context curr_ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);

        addI = (Button) findViewById(R.id.button13);
        addI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchItem();
            }
        });

    }

    public void openSearchItem() {
        Intent intentAddI = new Intent(curr_ctx, SearchItemScreen.class);
        curr_ctx.startActivity(intentAddI);
    }
}
