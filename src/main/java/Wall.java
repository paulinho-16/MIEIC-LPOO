import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;

    Wall(int x, int y) {
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#0a0580"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf(Symbols.BLOCK_SOLID));
    }
}
