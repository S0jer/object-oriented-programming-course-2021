package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;

import java.util.Map;

public class RectangularMap implements WorldMap {

    private int width;
    private int height;
    private Map<> map = new Map() {
    };



    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }


    @Override
    public boolean place(Animal animal) {
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }


}
