package agh.ics.oop.lab4;


import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.OptionsParser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

public class AnimalsBoard extends JPanel implements ActionListener {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 400;
    private final JButton startButton;
    private final JTextField arguments;
    private final JTextField positions;

    public AnimalsBoard(int width, int height) {

        arguments = new JTextField();
        arguments.setBounds(100, 75, 200, 30);
        positions = new JTextField();
        positions.setBounds(100, 125, 200, 30);

        startButton = new JButton("Start");
        startButton.setBounds(100, 200, 200, 30);
        startButton.addActionListener(this);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.GRAY);
        setLayout(null);

        add(arguments);
        add(positions);
        add(startButton);

    }

    public void loadImages() {
        ImageIcon rabbit = new ImageIcon(ClassLoader.getSystemResource("E:\\Kodzenie\\Java\\00lab"));
        ImageIcon grass = new ImageIcon();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
    }

//    String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//    List<MoveDirection> directions = new OptionsParser().parse(arguments);
//    Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//
//    WorldMap map = new RectangularMap(10, 5);
//    Engine enegine = new SimulationEngine(directions, map, positions);
//    System.out.println(map.toString(map));
//    enegine.run();
//    System.out.println(map.toString(map));

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = arguments.getText();
        String pos = positions.getText();

        char[] argArray = arg.toCharArray();
        char[] posArray = pos.toCharArray();
        ArrayList<Integer> positionsInt = new ArrayList<>();

        for (char p : posArray) {
            positionsInt.add(Integer.parseInt(String.valueOf(p)));
        }

        System.out.println(arg);
        System.out.println(pos);

        Object source = e.getSource();
        if (source == startButton) {
        }
    }

}
