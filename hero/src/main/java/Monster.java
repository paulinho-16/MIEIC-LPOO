import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y) {
        super(x,y);
    }

    public boolean MonstersCollisions(List<Wall> walls, Position posicao) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(posicao))
                return true;
        }
        return false;
    }

    public Position move(List<Wall> walls) {
        boolean repetir = true;
        while (repetir) {
            repetir = false;
            Random random = new Random();
            int movimento = random.nextInt(4);
            Position posicao = getPosition();
            switch (movimento) {
                case 0:
                    posicao = new Position(getPosition().getX() + 1, getPosition().getY());
                    break;
                case 1:
                    posicao = new Position(getPosition().getX() - 1, getPosition().getY());
                    break;
                case 2:
                    posicao = new Position(getPosition().getX(), getPosition().getY() + 1);
                    break;
                case 3:
                    posicao = new Position(getPosition().getX(), getPosition().getY() - 1);
                    break;
            }
            if (MonstersCollisions(walls, posicao))
                repetir = true;
            else
                return posicao;
        }
        return null;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#e60000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}
