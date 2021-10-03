import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{

    public Wall(int x, int y) {
        super(x,y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#0a0580"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), String.valueOf(Symbols.BLOCK_SOLID));
    }
}
