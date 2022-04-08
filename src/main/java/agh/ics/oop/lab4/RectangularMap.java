package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;
import agh.ics.oop.lab5.AbstractWorldMap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public String toString(WorldMap map) {
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }


}
