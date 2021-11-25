package agh.ics.oop.lab1;

import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab3.Animal;
import agh.ics.oop.lab3.OptionsParser;

import java.util.List;

public class World extends OptionsParser {
    public static void main(String[] args) {
        String[] moves = {"r", "f", "f", "f", "f", "f", "c"};
        Animal animal = new Animal();

        System.out.println(animal.toString());

        List<MoveDirection> directions = parse(moves);
        for (MoveDirection direction : directions) {
            animal.move(direction);
        }

        System.out.println(animal.toString());


    }
}
