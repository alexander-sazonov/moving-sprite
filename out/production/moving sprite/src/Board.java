import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private SpaceShip spaceShip;
    private Timer timer;

    public Board(){
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(),this);
        List<Bullet> bullets = spaceShip.getBullets();
        for (Bullet bullet: bullets){
           g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void updateBullets(){
        List<Bullet> bullets = spaceShip.getBullets();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet.isVisible()){
                bullet.move();
            }else {
                bullets.remove(i);
            }
        }
    }

    private void updateSpaceShip(){
        spaceShip.move();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateBullets();
        updateSpaceShip();
        repaint();
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }
    }
}
