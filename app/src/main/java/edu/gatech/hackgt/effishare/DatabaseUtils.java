package edu.gatech.hackgt.effishare;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class DatabaseUtils {

    private static final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private static List<Item> checkedList;

    public static List<Item> getCheckedOutItems(String userUUID) {
        ref.child("users").child(userUUID).child("checkedOut").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                checkedList =  dataSnapshot.getValue(List.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        while (checkedList == null) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        List<Item> retVal = checkedList;
        checkedList = null;
        return retVal;
    }

    private static String communityString;

    public static String getCommunity(String userUUID) {
        ref.child("users").child(userUUID).child("community").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                communityString =  dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        while (communityString == null) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        String retVal = communityString;
        communityString = null;
        return retVal;
    }

    public static void addUserToDB(User user) {
        user.writeToDatabase();
    }

    /**
     * Updates the community of the user object and adds the user object to the community object
     * @param uuid
     * @param community
     */
    public static void updateUserCommunity(String uuid, String community) {
        ref.child("users").child(uuid).child("community").setValue(community);
    }


    private DatabaseUtils() {}
}
