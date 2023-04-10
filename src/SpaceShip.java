import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite{
    private int dx;
    private int dy;
    List<Bullet> bullets;

    public SpaceShip(int x, int y) {
        super(x, y);
        loadImage("space.png");
        getImageDimensions();
        bullets = new ArrayList<>();
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public void fire(){
        bullets.add(new Bullet(x + width, y + height / 2));
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT){
            dx = 1;
        }
        if (key == KeyEvent.VK_UP){
            dy = 1;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = -1;
        }
        if (key == KeyEvent.VK_SPACE){
            fire();
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT){
            dx = 0;
        }
        if (key == KeyEvent.VK_UP){
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }
}
