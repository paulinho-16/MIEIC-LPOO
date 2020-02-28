import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        walls = createWalls();
        coins = createCoins();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
            walls.add(new Wall(1, r));
            walls.add(new Wall(width - 2, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        while (coins.size() < 5) {
            boolean encontrado = false;
            Coin coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            for (Coin moeda : coins) {
                if (moeda.position.equals(coin.position)) {
                    encontrado = true;
                    break;
                }
            }
            if (coin.position.equals(hero.position) || encontrado)
                continue;
            coins.add(coin);
        }
        return coins;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        hero.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() >= 0 && position.getX() < width) {
            if (position.getY() >= 0 && position.getY() < height) {
                for (Wall wall : walls) {
                    if (wall.getPosition().equals(position))
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    public void retrieveCoins() {
        for (Coin coin : coins) {
            if (coin.position.equals(hero.position)) {
                coins.remove(coin);
                break;
            }
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
        retrieveCoins();
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp()); break;
            case ArrowDown:
                moveHero(hero.moveDown()); break;
            case ArrowLeft:
                moveHero(hero.moveLeft()); break;
            case ArrowRight:
                moveHero(hero.moveRight()); break;
        }
    }
}
