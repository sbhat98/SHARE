package edu.gatech.hackgt.effishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Join_create extends AppCompatActivity {
    private Button create;
    private Button join;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Context curr_ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_create);

        create = (Button) findViewById(R.id.button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateCommunity();
            }
        });

        join = (Button) findViewById(R.id.button2);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoinCommunity();
            }
        });
    }

    public void openCreateCommunity() {
        Intent intentCreate = new Intent(curr_ctx, CreateCommunity.class);
        curr_ctx.startActivity(intentCreate);
    }

    public void openJoinCommunity() {
        Intent intentCreate = new Intent(curr_ctx, JoinCommunityScreen.class);
        curr_ctx.startActivity(intentCreate);
    }

}
