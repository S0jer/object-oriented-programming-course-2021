package agh.ics.oop.lab1;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.gui.App;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.OptionsParser;
import agh.ics.oop.lab4.SimulationEngine;
import agh.ics.oop.lab5.GrassField;
import javafx.application.Application;

import java.util.List;

public class World extends OptionsParser {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);

        } catch(IllegalArgumentException ex){
            System.out.println("Wrong code");
        }


    }
}
