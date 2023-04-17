import javax.swing.JFrame;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow(){
        add(new Board());
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GameWindow game = new GameWindow();
            game.setVisible(true);
        });
    }
}
