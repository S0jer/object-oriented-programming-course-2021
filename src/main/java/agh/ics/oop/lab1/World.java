package agh.ics.oop.lab1;

import agh.ics.oop.lab1.Direction;
import agh.ics.oop.lab2.MapDirection;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
//        String[] moves = {"f", "l", "r", "l"};
//
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//    for (MapDirection direction : MapDirection.values()){
//        System.out.println(direction.toString());
//        System.out.println(direction.next().toString());
//        System.out.println(direction.previous().toString());
//        System.out.println(direction.toUnitVector().toString());
//        System.out.println();
//    }


    }

    static void run(String[] moves) {


        ArrayList<Direction> M = new ArrayList<>();

        for (String move : moves) {
            if (move.equals("f")) {
                M.add(Direction.FORWARD);
            } else if (move.equals("r")) {
                M.add(Direction.RIGHT);
            } else if (move.equals("l")) {
                M.add(Direction.LEFT);
            } else M.add(Direction.BACKWARD);
        }


        for (Direction move : M) {
            String message = switch (move) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }


}
