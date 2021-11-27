package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements WorldMap {


    private int width;
    private int height;
    private List<List<Animal>> map = new ArrayList<>();



    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public String toString(){

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return map.get(position.x).get(position.y).equals(new Animal());
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
        return map.get(position.x).get(position.y);
    }


}
