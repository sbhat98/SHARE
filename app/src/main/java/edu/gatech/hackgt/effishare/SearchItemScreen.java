package edu.gatech.hackgt.effishare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchItemScreen extends AppCompatActivity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item_screen);

        ListView lv = findViewById(R.id.listview_items);
        final List<String> item_list = new ArrayList<>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
          this,
          android.R.layout.simple_list_item_1,
                item_list
        );

        lv.setAdapter(arrayAdapter);
        final ArrayList<Item> item_data_list = new ArrayList<>();
        final ValueEventListener itemsValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Community c = dataSnapshot.getValue(Community.class);
                final ValueEventListener singleItemValueListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.println(Log.DEBUG, "Item debug", "Got item");
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
}
