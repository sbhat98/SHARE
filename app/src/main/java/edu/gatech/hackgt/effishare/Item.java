package edu.gatech.hackgt.effishare;

import java.util.Objects;

/**
 * Item class with name, owner, description, security deposit, check out status, photoURL
 * and an itemID
 */
public class Item {

    private String itemName;
    private String owner;  // no setter method
    private String itemDescription;
    private double securityDepositValue;
    private boolean isCheckedOut;
    private String itemPhotoURL;
    private final int itemID;
    private static int idCounter = 0;

    public Item(String itemName, String owner, String itemDescription,
                double securityDepositValue, boolean isCheckedOut, String itemPhotoURL) {
        this.itemName = itemName;
        this.owner = owner;
        this.itemDescription = itemDescription;
        this.securityDepositValue = securityDepositValue;
        this.isCheckedOut = isCheckedOut;
        this.itemPhotoURL = itemPhotoURL;
        this.itemID = ++idCounter;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOwner() {
        return owner;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getSecurityDepositValue() {
        return securityDepositValue;
    }

    public void setSecurityDepositValue(double securityDepositValue) {
        this.securityDepositValue = securityDepositValue;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean IsCheckedOut) {
        isCheckedOut = IsCheckedOut;
    }

    public String getItemPhotoURL() {
        return itemPhotoURL;
    }

    public void setItemPhotoURL(String itemPhotoURL) {
        this.itemPhotoURL = itemPhotoURL;
    }

    @Override
    public String toString() {
        return "" + this.getItemName() + " is owned by " + this.getOwner()
                + " and has a security deposit of $" + this.getSecurityDepositValue()
                + ". This item is" + (this.getIsCheckedOut() ? " currently checked out"
                : " available for rent");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return this.itemID == item.itemID;
    }

    @Override
    public int hashCode() {
        return itemID;
    }

}
