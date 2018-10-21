package edu.gatech.hackgt.effishare;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class User {

    private String username;
    private String email;
    private String userID;
    private List<String> checkedOut;
    private List<String> putOut;
    private String community;

    public static User currentUser;
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public List<String> getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(List<String> checkedOut) {
        this.checkedOut = checkedOut;
    }

    public List<String> getPutOut() {
        return putOut;
    }

    public void setPutOut(List<String> putOut) {
        this.putOut = putOut;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

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
        return this.userID.equals(user.userID);
    }

    @Override
    public int hashCode() { return userID.hashCode(); }


    @Override
    public String toString() {
        return  "\nUsername: " + this.getUsername()
                + "\ne-mail: " + this.getEmail();
    }

    private static Map<String, Object> arrayToMap(List<String> a) {
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
