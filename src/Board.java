import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private final int BOARD_HEIGHT = 300;
    private final int BOARD_WIDTH = 400;
    private SpaceShip spaceShip;
    private Timer timer;
    List<Alien> aliens;

    public Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);
        timer = new Timer(DELAY, this);
        timer.start();
        initAliens();
    }

    private void initAliens() {
        Random rnd = new Random();
        aliens = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int alienX = rnd.nextInt(BOARD_WIDTH);
            int alienY = rnd.nextInt(BOARD_HEIGHT / 2);
            Alien alien = new Alien(alienX, alienY);
            aliens.add(alien);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
        List<Bullet> bullets = spaceShip.getBullets();
        for (Bullet bullet : bullets) {
            g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
        }
        for(Alien alien: aliens){
            g2d.drawImage(alien.getImage(),alien.getX(), alien.getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void updateBullets() {
        List<Bullet> bullets = spaceShip.getBullets();
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet.isVisible()) {
                bullet.move();
            } else {
                bullets.remove(i);
            }
        }
    }

    private void updateSpaceShip() {
        spaceShip.move();
    }

    private void updateAliens(){
        Random rnd = new Random();
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            if (alien.isVisible()){
                alien.move();
            }else {
               // aliens.remove(i);
                alien.x = rnd.nextInt(BOARD_WIDTH);
                alien.y = rnd.nextInt(BOARD_HEIGHT / 2);
                alien.visible = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateBullets();
        updateSpaceShip();
        updateAliens();
        checkCollisions();
        repaint();
    }

    public void checkCollisions(){
        List<Bullet> bullets = spaceShip.getBullets();
        for (Bullet bullet: bullets){
            Rectangle bulletBounds = bullet.getBounds();
            for(Alien alien: aliens){
                Rectangle alienBounds = alien.getBounds();
                if (bulletBounds.intersects(alienBounds)){
                    alien.visible = false;
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {
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
