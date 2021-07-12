package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ivedent Lloyd III
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class ListMakerController implements Initializable {

    // create skeleton outline of the gui using scene builder
    // use sample controller skeleton and copy event handlers
    // make sure each handler has @FXML before
    // code will have add button and delete button
    // code must allow editing of list

    @FXML
    private TableView<items> tableView;

    @FXML
    private TableColumn<items, String> itemsStatusColumn;

    @FXML
    private TableColumn<items, String> itemDueDateColumn;

    @FXML
    private TableColumn<items, String> itemsNameColumn;

    @FXML
    private TableColumn<items, String> itemsDescriptionColumn;

    @FXML
    private TextField newItemTitleTextField;

    @FXML
    private TextField newItemDueDateTextField;

    @FXML
    private TextField newItemDescriptioinTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // fill data table with sample data
        // data must be filled using arrays
        // table must be editable
        // buttons have to be used to add and delete rows
        loadTableSampleData();
        initializeTable();

    }

    public void initializeTable(){
        initializeColumns();
    }

    public void initializeColumns(){
        // columns must be formatted using items class
        // format using getters and setters in another class for the items
        itemsStatusColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemStatus"));
        itemDueDateColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemDueDate"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemName"));
        itemsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemDescription"));

        // edit the columns using edit columns method
        editColumns();
    }

    public void editColumns(){

        // this method is to allows the items in the columns to be edited by the user
        // allow the user to click the items on the table to edit them
        itemsStatusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemsStatusColumn.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItemStatus(e.getNewValue());
        });
        itemDueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemDueDateColumn.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItemDueDate(e.getNewValue());
        });
        itemsNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemsNameColumn.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItemName(e.getNewValue());
        });
        itemsDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemsDescriptionColumn.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setItemDescription(e.getNewValue());
        });

        tableView.setEditable(true);

    }

    public void loadTableSampleData(){
        // load sample data
        // data must also be edited by the user and can be deleted completely
        ObservableList<items> sampleData = FXCollections.observableArrayList();
        sampleData.add(new items("completed", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("incomplete", "2021-07-13", "Assignment 5", "design a gui for a guessing game"));
        sampleData.add(new items("completed", "2021-07-15", "Homework 5", "turn in early for bonus"));
        sampleData.add(new items("incomplete", "2021-07-17", "Bonus 4", "boosts homework grade by 5"));
        sampleData.add(new items("incomplete", "2021-07-21", "Assignment 6", "details not released yet"));
        sampleData.add(new items("incomplete", "2021-07-22", "Exam 2", "study the last 3 chapters"));

        tableView.setItems(sampleData);
    }

    public void addButtonClicked(ActionEvent actionEvent) {
        // the button must add a new item name, due date, and description
        // the user then can edit the status upon completion
        // get the text input from the user
        // after the user clicks button, array values must be populated and displayed correctly
        // after the user enters, the text windows must be cleared
        items newItem = new items();
        newItem.setItemDueDate(newItemDueDateTextField.getText());
        newItem.setItemName(newItemTitleTextField.getText());
        newItem.setItemDescription(newItemDescriptioinTextField.getText());
        tableView.getItems().addAll(newItem);

        newItemDueDateTextField.clear();
        newItemTitleTextField.clear();
        newItemDescriptioinTextField.clear();

    }

    public void deleteButtonClicked(ActionEvent actionEvent) {

        // allow the user to highlight a row in the column and delete it from the array
        // remove all items from the array index
        ObservableList<items> itemSelected, allItems;
        allItems = tableView.getItems();
        itemSelected = tableView.getSelectionModel().getSelectedItems();

        itemSelected.forEach(allItems::remove);

    }
}
