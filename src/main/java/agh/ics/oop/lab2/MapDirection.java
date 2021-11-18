package agh.ics.oop.lab2;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        switch (this) {
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public MapDirection next() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH:
                return new Vector2d(0, 1);
            case SOUTH:
                return new Vector2d(0, -1);
            case EAST:
                return new Vector2d(1, 0);
            case WEST:
                return new Vector2d(-1, 0);
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

}
