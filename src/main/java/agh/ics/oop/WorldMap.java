package agh.ics.oop;

import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;

public interface WorldMap {

    boolean canMoveTo(Vector2d position);

    boolean place(Animal animal);

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);

}
