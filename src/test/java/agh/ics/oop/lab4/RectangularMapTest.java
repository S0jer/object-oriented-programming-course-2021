package agh.ics.oop.lab4;

import agh.ics.oop.WorldMap;
import agh.ics.oop.lab2.Vector2d;
import agh.ics.oop.lab3.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangularMapTest {

    @Test
    void shouldBeAbleToMoveAnimalInEmptyMap() {
        WorldMap map = new RectangularMap(5, 5);

        boolean result = map.canMoveTo(new Vector2d(1, 1));

        assertThat(result).isTrue();
    }

    @Test
    void shouldCheckIfPlaceIsOccupied(){
        WorldMap map = new RectangularMap(5, 5);

        boolean result = map.isOccupied(new Vector2d(2, 2));

        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseWhenIdexOutsideOfMap() {
        RectangularMap map = new RectangularMap(5, 5);

        boolean result = map.isOccupied(new Vector2d( -1, -1));

        assertThat(result).isFalse();

    }


    @Test
    void shouldCheckWhichObjectIsOnTheXYInstanceOfMap(){
        WorldMap map = new RectangularMap(5,5);

        assertThat(map.objectAt(new Vector2d(2, 2))).isNotEqualTo(new Animal(new RectangularMap(4, 4)));
    }


    @Test
    void shouldBeAbleToPlaceAnimaInEmptyMap() {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2), map);

        map.place(animal);

        assertThat(map.objectAt(new Vector2d(2,2))).isEqualToComparingFieldByField(animal);
    }

}