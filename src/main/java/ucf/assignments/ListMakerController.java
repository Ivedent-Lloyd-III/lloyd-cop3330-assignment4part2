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

import java.net.URL;
import java.util.ResourceBundle;

public class ListMakerController implements Initializable {

    @FXML
    private TableView<listItems> tableView;

    @FXML
    private TableColumn<listItems, String> itemsStatusColumn;

    @FXML
    private TableColumn<listItems, String> itemDueDateColumn;

    @FXML
    private TableColumn<listItems, String> itemsNameColumn;

    @FXML
    private TableColumn<listItems, String> itemsDescriptionColumn;

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
    

    ObservableList<listItems> list = FXCollections.observableArrayList(
            new listItems("incompleted", "071321", "Wash Dog", "Wash the dog with shampoo"),
            new listItems("completed", "071321", "Wash Car", "wash the car with soap")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        itemsStatusColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemStatus"));
        itemDueDateColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemDueDate"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemName"));
        itemsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<listItems, String>("itemDescription"));

        tableView.setItems(list);
    }

    public void addButtonClicked(ActionEvent actionEvent) {
        listItems newItem = new listItems();
        newItem.setItemDueDate(newItemDueDateTextField.getText());
        newItem.setItemName(newItemTitleTextField.getText());
        newItem.setItemDescription(newItemDescriptioinTextField.getText());
        tableView.getItems().addAll(newItem);

        newItemDueDateTextField.clear();
        newItemTitleTextField.clear();
        newItemDescriptioinTextField.clear();

    }

    public void deleteButtonClicked(ActionEvent actionEvent) {

        ObservableList<listItems> itemSelected, allItems;
        allItems = tableView.getItems();
        itemSelected = tableView.getSelectionModel().getSelectedItems();

        itemSelected.forEach(allItems::remove);

    }
}
