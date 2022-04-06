package agh.ics.oop.lab1;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;
import agh.ics.oop.lab3.OptionsParser;
import agh.ics.oop.lab4.MapVisualizer;
import agh.ics.oop.lab4.MyFrame;
import agh.ics.oop.lab4.RectangularMap;
import agh.ics.oop.lab4.SimulationEngine;

import java.awt.EventQueue;

import java.util.List;

public class World extends OptionsParser {
    public static void main(String[] args) {

        String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(arguments);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

        WorldMap map = new RectangularMap(10, 5);
        Engine enegine = new SimulationEngine(directions, map, positions);
        System.out.println(map.toString(map));
        enegine.run();
        System.out.println(map.toString(map));


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(10, 6, directions, positions);
            }
        });

    }
}
