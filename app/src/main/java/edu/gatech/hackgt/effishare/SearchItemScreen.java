package edu.gatech.hackgt.effishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchItemScreen extends AppCompatActivity {
    private Button request;
    private Button checked;
    private Button message;
    private Button addItem;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Context curr_ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item_screen);

        addItem = (Button) findViewById(R.id.button9);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd_Item();
            }
        });

        message = (Button) findViewById(R.id.button12);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMessenger();
            }
        });

        checked = (Button) findViewById(R.id.button11);
        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChecked();
            }
        });

        request = (Button) findViewById(R.id.button10);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRentReq();
            }
        });
    }

    public void openAdd_Item() {
        Intent intentAddI = new Intent(curr_ctx, Add_Item.class);
        curr_ctx.startActivity(intentAddI);
    }

    public void openMessenger() {
        Intent intentChat = new Intent(curr_ctx, ChatActivity.class);
        curr_ctx.startActivity(intentChat);
    }

    public void openChecked() {
        Intent intentCheck = new Intent(curr_ctx, CheckedOut.class);
        curr_ctx.startActivity(intentCheck);
    }

    public void openRentReq() {
        Intent intentReq = new Intent(curr_ctx, Renter_List.class);
        curr_ctx.startActivity(intentReq);
    }

}
