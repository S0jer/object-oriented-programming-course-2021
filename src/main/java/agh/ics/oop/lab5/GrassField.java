package agh.ics.oop.lab5;

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
    private int mapSize = 1;


    public GrassField(int grassFieldsNumber) {
        this.grassFields = grassFieldsNumber;
        setGrass();
    }


    private void setGrass() {
        Random random = new Random();
        int i = 0;
        while (i < this.grassFields) {
            int x = random.nextInt((int) sqrt(this.grassFields * 10));
            int y = random.nextInt((int) sqrt(this.grassFields * 10));
            Vector2d vector2d = new Vector2d(x, y);
            if (this.grassMap.get(vector2d) == null) {
                this.grassMap.put(vector2d, new Grass(vector2d));
                i++;
            }
        }

    }


}
