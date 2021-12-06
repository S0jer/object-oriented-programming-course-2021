package agh.ics.oop;

import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;

public interface WorldMap {

    String toString(WorldMap map);

    boolean canMoveTo(Vector2d position);

    boolean place(Animal animal);

    boolean isOccupied(Vector2d position);

    void moveOnMap(MoveDirection direction, Vector2d vector2d);

    Object objectAt(Vector2d position);

}
