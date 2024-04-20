import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    // instance varables
    // window size
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 600;

    // width of square and where it is supposed to be

    // images
    private Image Image;
    private Game game;

    // constructor
    public GameViewer(Game game) {
        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Title");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {

    }
}
