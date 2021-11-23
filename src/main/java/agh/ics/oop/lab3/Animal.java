package agh.ics.oop.lab3;

import agh.ics.oop.lab2.MapDirection;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d animalPosition;
    private final Vector2d bottomBorder = new Vector2d(0, 0);
    private final Vector2d upperBorder = new Vector2d(4, 4);
    private WorldMap map;

    public Animal(WorldMap map) {
        this.map = map;
    }

    public Animal(WorldMap map, Vector2d animalPosition) {
        this.map = map;
        this.animalPosition = animalPosition;
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
        return position == animalPosition;
    }

//    public void move(MoveDirection direction) {
//        switch (direction) {
//            case RIGHT:
//                this.orientation = this.orientation.next();
//                break;
//            case LEFT:
//                this.orientation = this.orientation.previous();
//                break;
//            case FORWARD:
//                if (upperBorder.precedes(this.animalPosition.add(this.orientation.toUnitVector())) && canMoveTo(this.animalPosition.add(this.orientation.toUnitVector()))) {
//                    this.animalPosition = this.animalPosition.add(this.orientation.toUnitVector());
//                }
//                break;
//            case BACKWARD:
//                if (bottomBorder.follows(this.animalPosition.subtract(this.orientation.toUnitVector())) && canMoveTo(this.animalPosition.subtract(this.orientation.toUnitVector()))) {
//                    this.animalPosition = this.animalPosition.subtract(this.orientation.toUnitVector());
//                }
//                break;
//        }
//
//    }

}