package agh.ics.oop.lab3;

import agh.ics.oop.MapElement;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MapDirection;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;

import java.util.Map;

public class Animal implements MapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d animalPosition;
    private final WorldMap map;


    public Animal(WorldMap map) {
        this.map = map;
    }

    public Animal(Vector2d animalPosition, WorldMap map) {
        this.animalPosition = animalPosition;
        this.map = map;
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case SOUTH -> "S";
            case NORTH -> "N";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d position) {
        return (position.x == animalPosition.x && position.y == animalPosition.y);


    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                if (map.canMoveTo(this.animalPosition.add(this.orientation.toUnitVector()))) {
                    this.animalPosition = this.animalPosition.add(this.orientation.toUnitVector());
                }
                break;
            case BACKWARD:
                if (map.canMoveTo(this.animalPosition.subtract(this.orientation.toUnitVector()))) {
                    this.animalPosition = this.animalPosition.subtract(this.orientation.toUnitVector());
                }
                break;
        }

    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public Vector2d getPosition() {
        return animalPosition;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public void setAnimalPosition(Vector2d animalPosition) {
        this.animalPosition = animalPosition;
    }


}