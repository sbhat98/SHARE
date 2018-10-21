package edu.gatech.hackgt.effishare;

/**
 * Item class with name, owner, description, security deposit, check out status, photoURL
 * and an ID
 */
public class Item {

    private String name;
    private String owner;  // no setter method
    private String description;
    private double securityDepositValue;
    private boolean checkedOut;
    private String itemPhotoURL;
    private int ID;

    public Item() {
        this("", "", "", 0, false, "");
    }

    public Item(String itemName, String owner, String itemDescription,
                double securityDepositValue, boolean isCheckedOut, String itemPhotoURL) {
        this.name = itemName;
        this.owner = owner;
        this.description = itemDescription;
        this.securityDepositValue = securityDepositValue;
        this.checkedOut = isCheckedOut;
        this.itemPhotoURL = itemPhotoURL;
        this.ID = 0;

    }

    public String getName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String itemDescription) {
        this.description = itemDescription;
    }

    public double getSecurityDepositValue() {
        return securityDepositValue;
    }

    public void setSecurityDepositValue(double securityDepositValue) {
        this.securityDepositValue = securityDepositValue;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItemPhotoURL() {
        return itemPhotoURL;
    }

    public void setItemPhotoURL(String itemPhotoURL) {
        this.itemPhotoURL = itemPhotoURL;
    }

    @Override
    public String toString() {
        return "" + this.getName() + " is owned by " + this.getOwner()
                + " and has a security deposit of $" + this.getSecurityDepositValue()
                + ". This item is" + (this.isCheckedOut() ? " currently checked out"
                : " available for rent");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return this.ID == item.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }

}
