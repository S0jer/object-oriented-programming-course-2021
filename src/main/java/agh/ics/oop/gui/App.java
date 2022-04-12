package agh.ics.oop.gui;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.OptionsParser;
import agh.ics.oop.lab4.SimulationEngine;
import agh.ics.oop.lab5.GrassField;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {


    public void runProgram(String[] arguments) {
        try {
//            String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            List<MoveDirection> directions = new OptionsParser().parse(arguments);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            WorldMap map = new GrassField(10);
            Engine enegine = new SimulationEngine(directions, map, positions);
            enegine.run();
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong code");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sceneB.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("E:\\Kodzenie\\Java\\00lab\\Images\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}
