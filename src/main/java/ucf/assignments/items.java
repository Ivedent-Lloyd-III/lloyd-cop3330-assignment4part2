package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ivedent Lloyd III
 */

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class items {

    private SimpleStringProperty itemName;
    private SimpleStringProperty itemDescription;
    private LocalDate itemDueDate;
    private SimpleStringProperty itemStatus;

    public items(String itemName, String itemDescription, LocalDate itemDueDate, String itemStatus) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.itemDueDate = itemDueDate;
        this.itemStatus = new SimpleStringProperty(itemStatus);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getItemDescription() {
        return itemDescription.get();
    }

    public SimpleStringProperty itemDescriptionProperty() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = new SimpleStringProperty(itemDescription);
    }

    public LocalDate getItemDueDate() {
        return itemDueDate;
    }

    public void setItemDueDate(LocalDate itemDueDate) {
        this.itemDueDate = itemDueDate;
    }

    public String getItemStatus() {
        return itemStatus.get();
    }

    public SimpleStringProperty itemStatusProperty() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = new SimpleStringProperty(itemStatus);
    }
}