package edu.gatech.hackgt.effishare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


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


        addItem = (Button) findViewById(R.id.button_show_additem);
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

        ListView lv = findViewById(R.id.listview_items);
        final List<String> item_list = new ArrayList<>();
        final ArrayList<Item> item_data_list = new ArrayList<>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
          this,
          android.R.layout.simple_list_item_1,
                item_list
        );

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Toast.makeText(curr_ctx, "You clicked " + item_data_list.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });

        final ValueEventListener itemsValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Community c = dataSnapshot.getValue(Community.class);
                final ValueEventListener singleItemValueListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        Log.println(Log.DEBUG, "Item debug", "Got item");
                        Item i = dataSnapshot.getValue(Item.class);
                        item_list.add(i.getName());
                        item_data_list.add(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };
                for (int id : c.getItems()) {
                    mDatabase.child("items").child("" + id).addListenerForSingleValueEvent(singleItemValueListener);
                }

//                while (item_data_list.size() < c.getItems().size()) {
//                    try {
//                        Thread.sleep(200);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.child("communities").child("" + User.currentUser.getCommunity()).addValueEventListener(itemsValueListener);
    }

    public void openAdd_Item() {
        Intent intentAdd = new Intent(curr_ctx, Add_Item.class);
        curr_ctx.startActivity(intentAdd);
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
