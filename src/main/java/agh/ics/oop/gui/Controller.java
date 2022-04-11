package agh.ics.oop.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.util.Arrays;

public class Controller {

    @FXML
    private TextField myData;
    @FXML
    private Button myButton;


    String[] arguments;


    public void Start(ActionEvent event){
        try {
            arguments = myData.getText().split("");
            System.out.println(Arrays.toString(arguments));
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
