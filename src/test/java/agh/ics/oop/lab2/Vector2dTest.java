package agh.ics.oop.lab2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static agh.ics.oop.lab2.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Vector2dTest {

    static Stream<Arguments> equalsVerificationArgumentsProvider(){
        return Stream.of(
                arguments(1, 1, new Vector2d(1, 1), true),
                arguments(1, 2, new Vector2d(1, 1), false),
                arguments(-10, 21, new Vector2d(-10, 21), true),
                arguments(12, -2, new Vector2d(-2, 12), false)
        );
    }

    @ParameterizedTest(name = "should return {3}")
    @MethodSource("equalsVerificationArgumentsProvider")
    void shouldVerifyEquals(int a, int b, Object check, boolean result){
        Vector2d vector2dTest = new Vector2d(a, b);

        assertEquals(vector2dTest.equals(check), result);

    }



}
