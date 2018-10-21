package edu.gatech.hackgt.effishare;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class User {

    private String username;
    private String email;
    private String password;
    private String name;
    private String userID;
    private List<Item> checkedOut;
    private List<Item> putOut;
    private String community;

    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public User(String username, String email, String name, String password, String userID) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.userID = userID;
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

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return this.userID.equals(user.userID);
    }

    @Override
    public int hashCode() { return userID.hashCode(); }


    @Override
    public String toString() {
        return  "\nUsername: " + this.getUsername()
                + "\ne-mail: " + this.getEmail();
    }

    public void writeToDatabase() {
        mDatabase.child("users").child(userID).child("name").setValue(name);
        mDatabase.child("users").child(userID).child("username").setValue(username);
        mDatabase.child("users").child(userID).child("uuid").setValue(userID);
        mDatabase.child("users").child(userID).child("checkedOut").setValue(checkedOut);
        mDatabase.child("users").child(userID).child("putOut").setValue(putOut);
        mDatabase.child("users").child(userID).child("community").setValue(community);
    }


}
