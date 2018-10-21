package edu.gatech.hackgt.effishare;

import java.util.Objects;

public class User {

    private String username;
    private String email;
    private String password;
    private String name;
    private String userID;

    public User(String username, String email, String name, String password) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
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

    public String getName() { return name; }

    public void setName(String name) {this.name = name; }

    public String getUserID() { return userID; }

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
        return "Name: " + this.getName()
                + "\nUsername: " + this.getUsername()
                + "\ne-mail: " + this.getEmail();
    }
}
