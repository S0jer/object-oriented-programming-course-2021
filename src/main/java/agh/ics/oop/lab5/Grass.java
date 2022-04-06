package agh.ics.oop.lab5;

import agh.ics.oop.lab2.Vector2d;

public class Grass {

    private Vector2d grassPosition;

    public Grass(Vector2d vector2d) {
        this.grassPosition = vector2d;
    }

    public Vector2d getGrassPosition() {
        return grassPosition;
    }

    @Override
    public String toString(){
        return "*";
    }

}
