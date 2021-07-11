package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ivedent Lloyd III
 */

public class itemsProperties {

    private String itemName;
    private String itemDescription;
    private String itemDueDate;
    private String itemCompleted;

    public itemsProperties(){
        this.itemName = "";
        this.itemDescription = "";
        this.itemDueDate = "";
        this.itemCompleted = "";
    }

    public itemsProperties(String itemName, String itemDescription, String itemDueDate, String itemCompleted){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemDueDate = itemDueDate;
        this.itemCompleted = itemCompleted;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDueDate() {
        return itemDueDate;
    }

    public void setItemDueDate(String itemDueDate) {
        this.itemDueDate = itemDueDate;
    }

    public String getItemCompleted() {
        return itemCompleted;
    }

    public void setItemCompleted(String itemCompleted) {
        this.itemCompleted = itemCompleted;
    }
}