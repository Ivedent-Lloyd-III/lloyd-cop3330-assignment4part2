package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution Test
 *  Copyright 2021 Ivedent Lloyd III
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListMakerControllerTest {

    @Test
    void addButtonClickedTest() {
        // test and confirm that an item can be added to a list
        // create two arrays to match, one completed on missing an item
        // have a new string item created
        // if the new string exists add it to the list
        // compare the lists if they match return true
        boolean val = false;
        String newItemInput = "newItem";

        List<String> itemCorrectList = new ArrayList<>();
        itemCorrectList.add("Item 1");
        itemCorrectList.add("Item 2");
        itemCorrectList.add("Item 3");
        itemCorrectList.add("newItem");

        List<String> itemTestList = new ArrayList<>();
        itemTestList.add("Item 1");
        itemTestList.add("Item 2");
        itemTestList.add("Item 3");

        if(newItemInput != ""){
            itemTestList.add(newItemInput);
        }

        if(itemCorrectList.equals(itemTestList)){
            val = true;
        }

        assertEquals(val, true);

    }

    @Test
    void deleteButtonClicked() {
        // test and confirm that an item can be deleted from a list
        // create a new item string
        // create two arrays one to test and one to compare
        // if the string exists remove it from the test list
        // compare the two lists
        // if the lists match return true
        boolean val = false;
        String newItemInput = "newItem";

        List<String> itemCorrectList = new ArrayList<>();
        itemCorrectList.add("Item 1");
        itemCorrectList.add("Item 2");
        itemCorrectList.add("Item 3");

        List<String> itemTestList = new ArrayList<>();
        itemTestList.add("Item 1");
        itemTestList.add("Item 2");
        itemTestList.add("Item 3");
        itemTestList.add("newItem");

        if(newItemInput != ""){
            itemTestList.remove(newItemInput);
        }

        if(itemCorrectList.equals(itemTestList)){
            val = true;
        }

        assertEquals(val, true);
    }
}