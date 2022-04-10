package agh.ics.oop.lab5;

import agh.ics.oop.PositionChangeObserver;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;
import agh.ics.oop.lab4.MapVisualizer;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private int grassFields;


    public GrassField(int grassFieldsNumber) {
        this.grassFields = grassFieldsNumber;
        this.borders = new MapBoundary();
        setGrass(grassFields);
    }


}
