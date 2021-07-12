package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ivedent Lloyd III
 */

public class items {
    // there are 4 variables the user can control, name, description, data and completion status
    // all will be input as strings
    // autocomplete getters and setters
    private String itemName;
    private String itemDescription;
    private String itemStatus;
    private String itemDueDate;

    public items(){
        // initialize all the input values
        this.itemName = "";
        this.itemDescription = "";
        this.itemStatus = "";
        this.itemDueDate = "";
    }

    public items(String itemStatus, String itemDueDate, String itemName, String itemDescription) {
        this.itemStatus = itemStatus;
        this.itemDueDate = itemDueDate;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public void setItemDueDate(String itemDueDate) {
        this.itemDueDate = itemDueDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public String getItemDueDate() {
        return itemDueDate;
    }
}
