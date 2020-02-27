import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x;
    private int y;

    Hero(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void draw(Screen screen) {
        screen.setCharacter(x, y, new TextCharacter('X'));
    }

    public void moveUP() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
}
