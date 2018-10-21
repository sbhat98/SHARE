package edu.gatech.hackgt.effishare;

import java.util.ArrayList;

public class Community {
    private String ID;
    private ArrayList<String> items;
    private ArrayList<String> users;

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
}
