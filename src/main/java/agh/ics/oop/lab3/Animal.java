package agh.ics.oop.lab3;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MapDirection;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d animalPosition = new Vector2d(2, 2);
    private final Vector2d bottomBorder = new Vector2d(0, 0);
    private final Vector2d upperBorder = new Vector2d(4, 4);
    private WorldMap map;

    public Animal() {
    }

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
                if (upperBorder.precedes(this.animalPosition.add(this.orientation.toUnitVector()))
                        && bottomBorder.follows(this.animalPosition.add(this.orientation.toUnitVector()))
                        && map.canMoveTo(this.animalPosition.add(this.orientation.toUnitVector()))) {
                    this.animalPosition = this.animalPosition.add(this.orientation.toUnitVector());
                }
                break;
            case BACKWARD:
                if (bottomBorder.follows(this.animalPosition.subtract(this.orientation.toUnitVector()))
                        && upperBorder.precedes(this.animalPosition.subtract(this.orientation.toUnitVector()))
                && map.canMoveTo(this.animalPosition.subtract(this.orientation.toUnitVector()))) {
                    this.animalPosition = this.animalPosition.subtract(this.orientation.toUnitVector());
                }
                break;
        }

    }



    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getAnimalPosition() {
        return animalPosition;
    }

    public Vector2d getBottomBorder() {
        return bottomBorder;
    }

    public Vector2d getUpperBorder() {
        return upperBorder;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public void setAnimalPosition(Vector2d animalPosition) {
        this.animalPosition = animalPosition;
    }


}