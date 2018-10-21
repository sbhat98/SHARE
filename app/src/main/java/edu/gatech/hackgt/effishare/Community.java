package edu.gatech.hackgt.effishare;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Community {
    private String ID;
    private ArrayList<String> items;
    private ArrayList<String> users;

    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public Community(String ID) {
        this.ID = ID;
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> retVal = new HashMap<>();
        retVal.put("ID", ID);
        retVal.put("items", items);
        retVal.put("users", users);
        return retVal;
    }

    public void writeToDatabase() {
        HashMap<String, Object> write = new HashMap<>();
        write.put("/communities/" + ID, toMap());
        mDatabase.updateChildren(write);
    }
}
