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
        Image = new ImageIcon("Resources/board.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PushBall");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public java.awt.Image getImage() {
        return Image;
    }

    public void paint(Graphics g) {
        if (game.getRounds() == 0){
            paintInstructions(g);
        }
        else {
            // clear the window
            if(game.isGameOver()){
                gameOver(g);
            }
            else {
                clearWindow(g);
                game.setGo(true);
                g.drawImage(Image, 50, 50, 700, 500, this);

                game.getMainBall().draw(g);
                game.getGun().draw(g);
                game.getComGun().draw(g);

                 game.getMiniBall().draw(g);

                game.getComMiniBall().draw(g);


            }

        }

    }
    public void paintInstructions(Graphics g){
        g.setColor(new Color(9, 241, 211, 255));
        g.setFont(new Font("Serif", Font.PLAIN, 80));
        g.drawString("PushBall", 200, 130);

        // draw the instructions
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("Welcome to PushBall! You and are playing against the computer!!", 100 ,200);
        g.drawString("You will have a gun and have to hit the ball in the middle and",100,250);
        g.drawString("get it on the side of the computer to win. Select a level to",100,300);
        g.drawString("play below. Good Luck!",100,350);

        g.setColor(Color.GREEN);
        g.drawString("Easy", 200, 450);

        g.setColor(Color.RED);
        g.drawString("Hard", 500, 450);

        g.setColor(Color.ORANGE);
        g.drawString("Extreme", 340, 500);



    }

    public void clearWindow(Graphics g){
        // clear the window
        g.setColor(Color.white);
        g.drawRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    public void gameOver(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 90));

//        g.drawString(game.getWinner(), 125, 300);
        if(game.getWinner().equals("You win!")){
            g.drawString(game.getWinner(), 200, 300);
        }
        else {
            g.drawString(game.getWinner(), 100, 300);
            g.drawString("wins :(", 250, 400);
        }
    }
}
