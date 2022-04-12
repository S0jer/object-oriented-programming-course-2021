package agh.ics.oop.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.util.Arrays;

public class Controller {

    @FXML
    private Label askForArguments;
    @FXML
    private TextField myData;
    @FXML
    private Button myButton;


    String[] arguments;


    public void Start(ActionEvent event) {
        try {
            boolean correct = true;
            arguments = myData.getText().split("");
            correct = false;
            for (String c : arguments) {
                if (!c.equals("f") || !c.equals("b") || !c.equals("r") || !c.equals("l")) {
                    correct = true;
                }
            }
            if (correct) {
                askForArguments.setText("             Enter arguments, only f, b, r, l letters:");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
