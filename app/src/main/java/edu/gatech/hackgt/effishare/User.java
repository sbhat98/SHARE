package edu.gatech.hackgt.effishare;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {

    private String username;
    private String email;
    private String userID;
    private ArrayList<Item> checkedOut;
    private ArrayList<Item> putOut;
    private String community;

    public static User currentUser;
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public User(String username, String email, String userID) {
        this.username = username;
        this.email = email;
        this.userID = userID;
    }

    public User() {
        this("", "", "");
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return this.userID == user.userID;
    }

    @Override
    public int hashCode() { return userID.hashCode(); }


    @Override
    public String toString() {
        return  "\nUsername: " + this.getUsername()
                + "\ne-mail: " + this.getEmail();
    }

    private static Map<String, Object> arrayToMap(ArrayList<Item> a) {
        if (a == null) {
            return null;
        }
        HashMap<String, Object> result = new HashMap<String, Object>();
        for (int i = 0; i < a.size(); i++) {
            result.put("" + i, a.get(i));
        }
        return result;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("username", username);
        result.put("checkedOut", arrayToMap(checkedOut));
        result.put("putOut", arrayToMap(putOut));
        result.put("community", community);
        result.put("email", email);
        return result;
    }

    public void writeToDatabase() {
        HashMap<String, Object> write = new HashMap<String, Object>();
        write.put("/users/" + userID, toMap());
        mDatabase.updateChildren(write);
    }

}
