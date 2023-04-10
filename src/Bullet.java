public class Bullet extends Sprite{
    private final int BULLET_SPEED = 2;
    private final int BOARD_WIDTH = 390;
    public Bullet(int x, int y) {
        super(x, y);
        loadImage("bullet.png");
        getImageDimensions();
    }
    public void move(){
        x += BULLET_SPEED;
        if (x > BOARD_WIDTH){
            visible = false;
        }
    }
}
