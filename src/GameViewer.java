import javax.swing.*;
import java.awt.*;

/**
 * GameViewer
 * Written by Sofia Aguilar on May 10, 2024
 *
 * Game creates a front end or window to my game and shows the images, shapes and the movement from the game.
 */

public class GameViewer extends JFrame {
    // Window size
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 600;

    // Board image
    private Image boardImage;
    // Connect with the backend
    private Game game;

    public GameViewer(Game game) {
        // Initializing the instance variables
        this.game = game;
        boardImage = new ImageIcon("Resources/board.png").getImage();
        // The window initialized
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PushBall");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // If game not start print menu
        if (game.isAtIntro()){
            paintMenu(g);
        }
        else {
            // When game is over
            if(game.isGameOver()){
                gameOver(g);
            }
            else {
                clearWindow(g);
                // Start the game and draw board
                game.setGameStarted(true);
                g.drawImage(boardImage, 50, 50, 700, 500, this);
                // Draw main ball
                game.getMainBall().draw(g);
                // Draw each gun
                game.getGun().draw(g);
                game.getComGun().draw(g);
                // Draw each mini ball
                game.getMiniBall().draw(g);
                game.getComMiniBall().draw(g);
            }
        }
    }
    public void paintMenu(Graphics g){
       // Draw the title
        g.setColor(new Color(9, 241, 211, 255));
        g.setFont(new Font("Serif", Font.PLAIN, 80));
        g.drawString("PushBall", 200, 130);

        // Draw the instructions
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("Welcome to PushBall! You are playing against the computer!!", 100 ,200);
        g.drawString("1) You will have a gun ",100,250);
        g.drawString("2) Aim and fire at the ball in the middle with the up arrow.",100,300);
        g.drawString("3) To win, get the ball to the computer side",100,350);
        g.drawString("To start, pick a level below.",100,400);

        // Drawing the Good Luck
        g.setFont(new Font("Courgette", Font.PLAIN, 25 ));
        g.drawString("Good Luck!",400,400);

        // Drawing out the levels
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.setColor(Color.GREEN);
        g.drawString("Easy", 200, 450);

        g.setColor(Color.RED);
        g.drawString("Hard", 500, 450);

        g.setColor(Color.ORANGE);
        g.drawString("Extreme", 340, 500);
    }

    public void clearWindow(Graphics g){
        // Clear the window
        g.setColor(Color.white);
        g.drawRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    public void gameOver(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 90));
        // If the winner is the user
        if(game.getWinner().equals("You win!")){
            g.drawString(game.getWinner(), 200, 300);
        }
        else {
            g.drawString(game.getWinner(), 100, 300);
            g.drawString("wins :(", 250, 400);
        }
    }
}