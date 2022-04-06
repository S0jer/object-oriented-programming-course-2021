package agh.ics.oop.lab4;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyFrame extends JFrame {

    public MyFrame(int width, int height, List<MoveDirection> directions, Vector2d[] positions) {
        super("AnimalsLife");
        JPanel board = new AnimalsBoard(width, height);
        add(board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        setLocation(700, 400);
        setVisible(true);


    }
}
