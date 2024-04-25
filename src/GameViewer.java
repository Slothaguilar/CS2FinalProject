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
    private Ball mainBall;


    // constructor
    public GameViewer(Game game, Ball mainBall) {
        this.game = game;
        this. mainBall = mainBall;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PushBall");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        if (game.getRounds() == 0){
            paintIntro(g);
        }
        else {
            // clear the window
            clearWindow(g);

            game.getMainBall().draw(g);
            game.getGun().draw(g);
        }

    }
    public void paintIntro(Graphics g){
        // draw the instructions
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("Instructions: Welcome to PushBall! You and are against the computer!!", 25 ,100);
        g.drawString("You will have a gun and have to hit the ball in the middle and get it",25,150);
        g.drawString("on the side of the computer. However the gun you have spins in a circle",25,200);
        g.drawString("so you will have to be careful when to press the gun. There will be 3",25,250);
        g.drawString( "rounds so make sure to win most of them! Good luck!",25,300);
    }
    public void clearWindow(Graphics g){
        // clear the window
        g.setColor(Color.white);
        g.drawRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
