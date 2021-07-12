package ucf.assignments;

import java.time.LocalDate;

public class items {

    private String itemName;
    private String itemDescription;
    private String itemStatus;
    private String itemDueDate;

    public items(){
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
