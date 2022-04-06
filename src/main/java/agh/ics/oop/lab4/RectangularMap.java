package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int width;
    private final int height;
    private final Map<Vector2d, Animal> animalMap;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animalMap = new HashMap<Vector2d, Animal>();
    }

    @Override
    public void moveOnMap(MoveDirection direction, Vector2d vector2d) {
        if (this.animalMap.get(vector2d) != null) {
            switch (direction) {
                case RIGHT -> this.animalMap.get(vector2d).setOrientation(this.animalMap.get(vector2d).getOrientation().next());
                case LEFT -> this.animalMap.get(vector2d).setOrientation(this.animalMap.get(vector2d).getOrientation().previous());
                case FORWARD -> {
                    int fx = vector2d.x + this.animalMap.get(vector2d).getOrientation().toUnitVector().x;
                    int fy = vector2d.y + this.animalMap.get(vector2d).getOrientation().toUnitVector().y;
                    Vector2d newVec = new Vector2d(fx, fy);
                    if (0 <= fx && 0 <= fy && this.animalMap.get(newVec) == null) {
                        this.animalMap.put(newVec, this.animalMap.get(vector2d));
                        this.animalMap.remove(vector2d);
                    }
                }
                case BACKWARD -> {
                    int fx = vector2d.x - this.animalMap.get(vector2d).getOrientation().toUnitVector().x;
                    int fy = vector2d.y - this.animalMap.get(vector2d).getOrientation().toUnitVector().y;
                    Vector2d newVec = new Vector2d(fx, fy);
                    if (0 <= fx && 0 <= fy && this.animalMap.get(newVec) == null) {
                        this.animalMap.put(newVec, this.animalMap.get(vector2d));
                        this.animalMap.remove(vector2d);
                    }
                }
            }
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (0 <= position.x && 0 <= position.y ) {
            Animal animal = animalMap.get(position);
            return animal == null;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getAnimalPosition();
        if (canMoveTo(animalPosition)) {
            this.animalMap.put(animal.getAnimalPosition(), animal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (0 <= position.x && position.x < width && 0 <= position.y && position.y < height) {
            return animalMap.get(position) != null;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalMap.get(position);
    }

    @Override
    public String toString(WorldMap map) {
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }
}
