package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements WorldMap {
    private final int width;
    private final int height;
    private final List<List<Animal>> map;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new ArrayList<>(width);
        for (int j = 0; j < width; j++) {
            this.map.add(j, new ArrayList<>(height));
            for (int i = 0; i < height; i++) {
                this.map.get(j).add(null);
            }
        }
    }

    @Override
    public void moveOnMap(MoveDirection direction, Vector2d vector2d) {
        if (this.map.get(vector2d.x).get(vector2d.y) != null) {
            switch (direction) {
                case RIGHT -> this.map.get(vector2d.x).get(vector2d.y).setOrientation(this.map.get(vector2d.x).get(vector2d.y).getOrientation().next());
                case LEFT -> this.map.get(vector2d.x).get(vector2d.y).setOrientation(this.map.get(vector2d.x).get(vector2d.y).getOrientation().previous());
                case FORWARD -> {
                    int fx = vector2d.x + this.map.get(vector2d.x).get(vector2d.y).getOrientation().toUnitVector().x;
                    int fy = vector2d.y + this.map.get(vector2d.x).get(vector2d.y).getOrientation().toUnitVector().y;
                    if (0 <= fx && fx < this.width && 0 <= fy && fy < this.height && this.map.get(fx).get(fy) == null) {
                        this.map.get(fx).set(fy, this.map.get(vector2d.x).get(vector2d.y));
                        this.map.get(vector2d.x).set(vector2d.y, null);
                    }
                }
                case BACKWARD -> {
                    int bx = vector2d.x - this.map.get(vector2d.x).get(vector2d.y).getOrientation().toUnitVector().x;
                    int by = vector2d.y - this.map.get(vector2d.x).get(vector2d.y).getOrientation().toUnitVector().y;
                    if ((0 <= bx) && (bx < this.width) && (0 <= (by) && (by) < this.height) && this.map.get(bx).get(by) == null) {
                        this.map.get(bx).set(by, this.map.get(vector2d.x).get(vector2d.y));
                        this.map.get(vector2d.x).set(vector2d.y, null);
                    }
                }
            }
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (0 <= position.x && position.x < this.width && 0 <= position.y && position.y < this.height) {
            Animal animal = map.get(position.x).get(position.y);
            return animal == null;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getAnimalPosition();
        if (canMoveTo(animalPosition)) {
            this.map.get(animal.getAnimalPosition().x).add(animal.getAnimalPosition().y, animal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (0 <= position.x && position.x < width && 0 <= position.y && position.y < height) {
            return map.get(position.x).get(position.y) != null;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map.get(position.x).get(position.y);
    }

    @Override
    public String toString(WorldMap map) {
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }
}
