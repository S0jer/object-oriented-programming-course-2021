package agh.ics.oop.lab4;

import agh.ics.oop.Engine;
import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.MoveDirection;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;
import agh.ics.oop.lab3.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RectangularMapTest {

    @Test
    void shouldBeAbleToMoveAnimalInEmptyMap() {
        WorldMap map = new RectangularMap(5, 5);

        boolean result = map.canMoveTo(new Vector2d(1, 1));

        assertThat(result).isTrue();
    }

    @Test
    void shouldBeAbleToMoveAnimalInEmptyMapFalse() {
        WorldMap map = new RectangularMap(5, 5);
        String[] args = {"l", "l"};
        List<MoveDirection> directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        Engine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        boolean result = map.canMoveTo(new Vector2d(2, 2));

        assertThat(result).isFalse();
    }

    @Test
    void shouldCheckIfPlaceIsOccupiedFalse() {
        WorldMap map = new RectangularMap(5, 5);

        boolean result = map.isOccupied(new Vector2d(2, 2));

        assertThat(result).isFalse();
    }

    @Test
    void shouldCheckIfPlaceIsOccupiedTrue() {
        WorldMap map = new RectangularMap(5, 5);
        String[] args = {"l", "l"};
        List<MoveDirection> directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        Engine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        boolean result = map.isOccupied(new Vector2d(2, 2));

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenIdexOutsideOfMap() {
        WorldMap map = new RectangularMap(5, 5);

        boolean result = map.isOccupied(new Vector2d(-1, -1));

        assertThat(result).isFalse();
    }

    @Test
    void shouldCheckWhichObjectIsOnTheXYInstanceOfMap() {
        WorldMap map = new RectangularMap(5, 5);
        assertThat(map.objectAt(new Vector2d(2, 2))).isNotEqualTo(new Animal(new RectangularMap(4, 4)));
    }

    @Test
    void shouldCheckWhichObjectIsOnTheXYInstanceOfMap2() {
        WorldMap map = new RectangularMap(5, 5);
        assertThat(map.objectAt(new Vector2d(2, 2))).isNotEqualTo(new Animal(new RectangularMap(4, 4)));
    }

    @Test
    void shouldBeAbleToPlaceAnimaInEmptyMap() {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2), map);

        map.place(animal);

        assertThat(map.objectAt(new Vector2d(2, 2))).isEqualToComparingFieldByField(animal);
    }

    @Test
    void shouldntBeAbleToPlaceAnimaInMap() {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2), map);
        map.place(animal);
        Assertions.assertThrows(IllegalArgumentException.class, () -> map.place(animal));
    }
}