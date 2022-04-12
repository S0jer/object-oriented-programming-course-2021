package agh.ics.oop.lab5;

public class GrassField extends AbstractWorldMap {
    private int grassFields;

    public GrassField(int grassFieldsNumber) {
        this.grassFields = grassFieldsNumber;
        this.borders = new MapBoundary();
        setGrass(grassFields);
    }
}
