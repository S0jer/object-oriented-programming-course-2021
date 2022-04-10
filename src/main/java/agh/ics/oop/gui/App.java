package agh.ics.oop.gui;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.OptionsParser;
import agh.ics.oop.lab4.SimulationEngine;
import agh.ics.oop.lab5.GrassField;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import agh.ics.oop.lab5.MapBoundary;

import java.util.List;
import java.util.Map;

public class App extends Application{



    public void start(Stage primaryStage){

        String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(arguments);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3   , 4)};
        WorldMap map = new GrassField(10);
        Engine enegine = new SimulationEngine(directions, map, positions);
        System.out.println(map.toString(map));
        enegine.run();
        System.out.println(map.toString(map));

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 400);
        gridPane.getColumnConstraints().add(new ColumnConstraints(10));
        gridPane.getRowConstraints().add(new RowConstraints(10));


        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                gridPane.add(new Button(), i, j, 1, 1);

            }
        }


        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        getParameters().getRaw();
        primaryStage.setTitle("Animals simulator");

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
