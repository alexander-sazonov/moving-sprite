public class Bullet extends Sprite{
    private final int BULLET_SPEED = 2;
    private final int BOARD_HEIGHT = 290;
    public Bullet(int x, int y) {
        super(x, y);
        loadImage("bullet.png");
        getImageDimensions();
    }
    public void move(){
        y -= BULLET_SPEED;
        if (y < 0){
            visible = false;
        }
    }
}
