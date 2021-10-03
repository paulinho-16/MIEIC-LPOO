package com.aor.refactoring.example5;

public class Turtle {
    private Position position;

    public Turtle(int row, int column, char direction) {
        position = new Position(row, column, direction);
    }

    public char getDirection() {
        return position.getDirection();
    }

    public int getRow() {
        return position.getRow();
    }

    public int getColumn() {
        return position.getColumn();
    }

    public void execute(char command) {
        switch(command) {
            case 'L':
                position.rotateLeft();
                break;
            case 'R':
                position.rotateRight();
                break;
            case 'F':
                position.moveForward();
                break;
            default:
                break;
        }
    }
}
