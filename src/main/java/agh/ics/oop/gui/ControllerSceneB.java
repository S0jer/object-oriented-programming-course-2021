package agh.ics.oop.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerSceneB extends ArgumentsHolder {

    @FXML
    private Label askForArguments;
    @FXML
    private TextField myData;
    @FXML
    private Button myButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void Start(ActionEvent event) {
        try {
            boolean correct = true;
            arguments = myData.getText().split("");
            correct = false;
            for (String c : arguments) {
                if (!c.equals("f") && !c.equals("b") && !c.equals("r") && !c.equals("l") &&
                !c.equals("F") && !c.equals("B") && !c.equals("R") && !c.equals("L")) {
                    correct = true;
                }
            }
            if (correct) {
                askForArguments.setText("             Enter arguments, only f, b, r, l letters:");
            } else{
                switchToSceneA(event);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void switchToSceneA(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sceneA.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
