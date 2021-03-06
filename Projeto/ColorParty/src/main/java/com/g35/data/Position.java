package com.g35.data;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position up() {
        return new Position(this.x, this.y - 1);
    }

    public Position right() {
        return new Position(this.x + 1, this.y);
    }

    public Position down() {
        return new Position(this.x, this.y + 1);
    }

    public Position left() {
        return new Position(this.x - 1, this.y);
    }

    public boolean samePosition(Position other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}