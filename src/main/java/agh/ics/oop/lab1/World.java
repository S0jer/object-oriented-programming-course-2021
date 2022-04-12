package agh.ics.oop.lab1;


import agh.ics.oop.gui.App;
import agh.ics.oop.lab3.OptionsParser;
import javafx.application.Application;

public class World extends OptionsParser {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong code");
        }
    }
}
