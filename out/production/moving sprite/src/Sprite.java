import javax.swing.*;
import java.awt.*;

public abstract class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String fileName){
        ImageIcon ii = new ImageIcon(fileName);
        image = ii.getImage();
    }
    protected void getImageDimensions(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public Image getImage() {
        return image;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
