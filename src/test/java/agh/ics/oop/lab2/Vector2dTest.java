package agh.ics.oop.lab2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Vector2dTest {

    static Stream<Arguments> equalsVerificationArgumentsProvider() {
        return Stream.of(
                arguments(1, 1, new Vector2d(1, 1), true),
                arguments(1, 2, new Vector2d(1, 1), false),
                arguments(-10, 21, new Vector2d(-10, 21), true),
                arguments(12, -2, new Vector2d(-2, 12), false)
        );
    }

    @ParameterizedTest(name = "should return {4}")
    @MethodSource("equalsVerificationArgumentsProvider")
    void shouldVerifyEquals(int a, int b, Object check, boolean result) {
        Vector2d vector2dTest = new Vector2d(a, b);

        assertEquals(vector2dTest.equals(check), result);

    }


    static Stream<Arguments> toStringVerificationArgumentsProvider() {
        return Stream.of(
                arguments(1, 1, "(" + 1 + ", " + 1 + ")"),
                arguments(1, 2, "(" + 1 + ", " + 2 + ")"),
                arguments(-10, 21, "(" + -10 + ", " + 21 + ")"),
                arguments(12, -2, "(" + 12 + ", " + -2 + ")")
        );
    }

    @ParameterizedTest(name = "should return {3}")
    @MethodSource("toStringVerificationArgumentsProvider")
    void shouldVerifyToString(int a, int b, String check) {
        Vector2d vector2dTest = new Vector2d(a, b);

        String result = vector2dTest.toString();

        assertEquals(result, check);

    }


    static Stream<Arguments> precedesVerificationArgumentsProvider() {
        return Stream.of(
                arguments(1, 1, 1, 2, true),
                arguments(1, 2, -10, 21, false),
                arguments(-10, 21, 1, 30, true),
                arguments(12, -2, 15, 2, true)
        );
    }

    @ParameterizedTest(name = "should return {5}")
    @MethodSource("precedesVerificationArgumentsProvider")
    void shouldVerifyPrecedes(int a, int b, int c, int d, boolean check) {
        Vector2d vector2d = new Vector2d(a, b);
        Vector2d vector2dPrecedes = new Vector2d(c, d);

        boolean result = vector2dPrecedes.precedes(vector2d);

        assertEquals(result, check);
    }


    static Stream<Arguments> followsVerificationArgumentsProvider() {
        return Stream.of(
                arguments(1, 1, 1, 2, true),
                arguments(1, 2, -10, 21, false),
                arguments(-10, 21, 1, 30, true),
                arguments(12, -2, 15, 2, true)
        );
    }

    @ParameterizedTest(name = "should return {5}")
    @MethodSource("followsVerificationArgumentsProvider")
    void shouldVerifyFollows(int a, int b, int c, int d, boolean check) {
        Vector2d vector2dFollows = new Vector2d(a, b);
        Vector2d vector2d = new Vector2d(c, d);

        boolean result = vector2dFollows.follows(vector2d);

        assertEquals(result, check);
    }


    static Stream<Arguments> upperRightVerificationArgumentsProvider() {
        return Stream.of(
                arguments(1, 1, 1, 2, 1, 2, true),
                arguments(1, 2, -10, 21, 1, 21, true),
                arguments(-10, 21, 1, 30, 1, 30, true),
                arguments(12, -2, 15, 2, 15, 2, true)
        );
    }

    @ParameterizedTest(name = "should return {7}")
    @MethodSource("upperRightVerificationArgumentsProvider")
    void shouldVerifyUpperRight(int a, int b, int c, int d, int check_a, int check_b, boolean check) {
        Vector2d vector2d_1 = new Vector2d(a, b);
        Vector2d vector2d_2 = new Vector2d(c, d);
        Vector2d vector2d_check = new Vector2d(check_a, check_b);

        Vector2d vector2d_connected = vector2d_1.upperRight(vector2d_2);

        boolean result = vector2d_check.equals(vector2d_connected);

        assertEquals(result, check);

    }


    static Stream<Arguments> lowerLeftVerificationArgumentsProvider() {
        return Stream.of(
                arguments(new Vector2d(1, 1), new Vector2d(1, 2), new Vector2d(1, 1), true),
                arguments(new Vector2d(1, 2), new Vector2d(-10, 21), new Vector2d(-10, 2), true),
                arguments(new Vector2d(-10, 21), new Vector2d(1, 30), new Vector2d(-10, 21), true),
                arguments(new Vector2d(12, -2), new Vector2d(15, 2), new Vector2d(12, -2), true)
        );
    }


    @ParameterizedTest(name = "should return {4}")
    @MethodSource("lowerLeftVerificationArgumentsProvider")
    void shouldVerifyLowerLeft(Vector2d vector2d_1, Vector2d vector2d_2, Vector2d vector2d_check, boolean check) {

        Vector2d vector2d_connected = vector2d_1.lowerLeft(vector2d_2);

        boolean result = vector2d_check.equals(vector2d_connected);

        assertEquals(result, check);

    }


    static Stream<Arguments> addVerificationArgumentsProvider() {
        return Stream.of(
                arguments(new Vector2d(1, 1), new Vector2d(1, 2), new Vector2d(2, 3), true),
                arguments(new Vector2d(1, 2), new Vector2d(-10, 21), new Vector2d(-9, 23), true),
                arguments(new Vector2d(-10, 21), new Vector2d(1, 30), new Vector2d(-9, 51), true),
                arguments(new Vector2d(12, -2), new Vector2d(15, 2), new Vector2d(27, 0), true)
        );
    }


    @ParameterizedTest(name = "should return {4}")
    @MethodSource("addVerificationArgumentsProvider")
    void shouldVerifyAdd(Vector2d vector2d_1, Vector2d vector2d_2, Vector2d vector2d_check, boolean check) {

        Vector2d vector2d_connected = vector2d_1.add(vector2d_2);

        boolean result = vector2d_check.equals(vector2d_connected);

        assertEquals(result, check);

    }


    static Stream<Arguments> subtractVerificationArgumentsProvider() {
        return Stream.of(
                arguments(new Vector2d(1, 1), new Vector2d(1, 2), new Vector2d(0, -1), true),
                arguments(new Vector2d(1, 2), new Vector2d(-10, 21), new Vector2d(11, -19), true),
                arguments(new Vector2d(-10, 21), new Vector2d(1, 30), new Vector2d(-11, -9), true),
                arguments(new Vector2d(12, -2), new Vector2d(15, 2), new Vector2d(-3, -4), true)
        );
    }


    @ParameterizedTest(name = "should return {4}")
    @MethodSource("subtractVerificationArgumentsProvider")
    void shouldVerifySubtract(Vector2d vector2d_1, Vector2d vector2d_2, Vector2d vector2d_check, boolean check) {

        Vector2d vector2d_connected = vector2d_1.subtract(vector2d_2);

        boolean result = vector2d_check.equals(vector2d_connected);

        assertEquals(result, check);

    }

    static Stream<Arguments> oppositeVerificationArgumentsProvider() {
        return Stream.of(
                arguments(new Vector2d(1, 1), new Vector2d(-1, -1), true),
                arguments(new Vector2d(1, 2), new Vector2d(-1, -2), true),
                arguments(new Vector2d(-10, 21), new Vector2d(10, -21), true),
                arguments(new Vector2d(12, -2), new Vector2d(-12, 2), true)
        );
    }


    @ParameterizedTest(name = "should return {4}")
    @MethodSource("oppositeVerificationArgumentsProvider")
    void shouldVerifyOpposite(Vector2d vector2d_1, Vector2d vector2d_check, boolean check) {

        Vector2d vector2d_op = vector2d_1.opposite();

        boolean result = vector2d_check.equals(vector2d_op);

        assertEquals(result, check);

    }


}
