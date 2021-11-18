package agh.ics.oop.lab3;

import agh.ics.oop.lab2.MoveDirection;

import java.util.ArrayList;

public class OptionsParser {

    public ArrayList<MoveDirection> parse(String[] moves){
        ArrayList<MoveDirection> directions = new ArrayList<MoveDirection>();

        for (String move : moves){
            switch (move){
                case "f":
                case "forward": directions.add(MoveDirection.FORWARD); break;
                case "b":
                case "backward": directions.add(MoveDirection.BACKWARD); break;
                case "r":
                case "right": directions.add(MoveDirection.RIGHT); break;
                case "l":
                case "left": directions.add(MoveDirection.LEFT); break;
            }
        }
        return directions;
    }
}
