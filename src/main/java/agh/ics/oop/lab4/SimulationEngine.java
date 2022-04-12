package agh.ics.oop.lab4;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements Engine {

    private final WorldMap map;
    private final List<MoveDirection> moveDirections;
    private final Vector2d[] vector2ds;
    private List<Animal> animalList;

    public SimulationEngine(List<MoveDirection> moveDirections, WorldMap map, Vector2d[] vector2ds) {
        this.map = map;
        this.moveDirections = moveDirections;
        this.vector2ds = vector2ds;
        addToMap();
    }

    private void addToMap() {
        int i = 0;
        this.animalList = new ArrayList<>();
        for (Vector2d vector2d : this.vector2ds) {
            this.animalList.add(new Animal(vector2d, this.map));
            this.map.place(animalList.get(i));
            i++;
        }
    }

    @Override
    public void run() {
        int i = 0;
        for (MoveDirection moveDirection : this.moveDirections) {
            this.animalList.get(i % this.animalList.size()).move(moveDirection);
            i++;
        }
    }
}
