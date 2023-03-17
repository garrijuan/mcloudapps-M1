package mcloudapps.utils.models;

public enum Direction {
    NORTH(1,0),
    NORTH_EAST(1,1),
    EAST(0,1),
    SOUTH_EAST(-1,1),
    SOUTH(-1,0),
    SOUTH_WEST(-1,-1),
    WEST(0,-1),
    NORTH_WEST(1,-1);

    public final int directionRow;
    public final int directionColumn;

    private Direction(int directionRow, int directionColumn) {
        this.directionRow = directionRow;
        this.directionColumn = directionColumn;
    }

    public Direction reverse() {
        return Direction.values()[(this.ordinal() + 4) % 8];
    }

    public static Direction[] halfValues (){
        Direction[] halfValues = new Direction[4];
        for (int i = 0; i < 4; i++) {
            halfValues[i] = Direction.values()[i];
        }
        return halfValues;
    }
}