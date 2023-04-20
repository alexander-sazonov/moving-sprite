public class Alien extends Sprite{

    private int alienSpeed = 2;
    public Alien(int x, int y) {
        super(x, y);
        loadImage("alien.png");
        getImageDimensions();
    }

    public void move(){
        if (y > 300){
            visible = false;
        }else {
            y += alienSpeed;
        }

    }

}
