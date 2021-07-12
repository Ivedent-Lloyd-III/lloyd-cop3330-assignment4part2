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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class ListMakerController implements Initializable {

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
    private Button addNewItemButton;

    @FXML
    private TextField newItemDescriptioinTextField;

    @FXML
    private Button deleteItemButton;
    

    ObservableList<items> list = FXCollections.observableArrayList(
            new items("incompleted", "071321", "Wash Dog", "Wash the dog with shampoo"),
            new items("completed", "071321", "Wash Car", "wash the car with soap")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadTableSampleData();
        initializeTable();

       // itemsStatusColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemStatus"));
       // itemDueDateColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemDueDate"));
       // itemsNameColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemName"));
       // itemsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemDescription"));

       // tableView.setItems(list);
    }

    public void initializeTable(){
        initializeColumns();
    }

    public void initializeColumns(){

        itemsStatusColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemStatus"));
        itemDueDateColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemDueDate"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemName"));
        itemsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<items, String>("itemDescription"));

        editColumns();
    }

    public void editColumns(){

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

        ObservableList<items> sampleData = FXCollections.observableArrayList();
        sampleData.add(new items("incompleted", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("incompleted", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("completed", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("completed", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("completed", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));
        sampleData.add(new items("completed", "2021-07-11", "Assignment 4", "design a gui that makes a todo list"));

        tableView.setItems(sampleData);
    }

    public void addButtonClicked(ActionEvent actionEvent) {
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

        ObservableList<items> itemSelected, allItems;
        allItems = tableView.getItems();
        itemSelected = tableView.getSelectionModel().getSelectedItems();

        itemSelected.forEach(allItems::remove);

    }
}
