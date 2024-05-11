import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Game
 * Written by Sofia Aguilar on May 10, 2024
 *
 * Game creates a back end to my game and causes for the movement on the screen.
 */

public class Game implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    // Levels
    private boolean easy;
    private boolean hard;
    private boolean extreme;

    // The x values of where each of the levels are
    private final int MINEXTREME = 330;
    private final int MAXEXTREME = 420;
    private final int MINHARD = 500;
    private final int MAXHARD = 550;
    private final int MINEASY = 200;
    private final int MAXEASY = 245;
    // The x values of when someone wins
    private int userWinsX = 168;
    private int computerWinsX = 565;

    private static final int DELAY_IN_MILLISEC = 20;     // Time delay between ball updates
    private GameViewer window;      // Connect to front end
    private Ball mainBall;
    // Users guns and balls
    private Gun gun;
    private MiniBall miniBall;
    // Computers guns and balls
    private Gun comGun;
    private MiniBall comMiniBall;
    // Winners name
    private String winner;
    private boolean gameOver;
    private boolean isAtIntro;
    private boolean isGameStarted;
    private int rounds;


    public Game() {
        // Set the game to not start yet
        isGameStarted = false;
        isAtIntro = true;
        rounds = 0;
        gameOver = false;

        // User's gun and ball
        gun = new Gun(650,50, Color.BLUE);
        Color color = new Color(56, 73, 220);
        miniBall = new MiniBall(gun.getX(), gun.getY(), -5, color);

        // Computer's gun and ball
        comGun = new Gun(50,50, Color.ORANGE);
        Color color1 = new Color(236, 147, 57);
        comMiniBall = new MiniBall(comGun.getX(), comGun.getX(), 7, color1);

        // Initialize main ball
        mainBall = new Ball(miniBall, comMiniBall);

        // Initialize the front-end
        window = new GameViewer(this);

        // Attaches to this KeyListener object
        window.addKeyListener(this);

        // Initialize winning stats variables
        this.winner = "";

        // Register the Mouse Listener and Mouse Motion Listener
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        // Sets up a timer but does not start it
        Timer clock = new Timer(DELAY_IN_MILLISEC, this);
        // Start the timer
        clock.start();

    }
    // Getter methods
    public void setGameStarted(boolean gameStarted) {
        this.isGameStarted = gameStarted;
    }

    public boolean isAtIntro() {
        return isAtIntro;
    }

    public MiniBall getComMiniBall() {
        return comMiniBall;
    }

    public Gun getComGun() {
        return comGun;
    }

    public MiniBall getMiniBall() {
        return miniBall;
    }

    public String getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public Ball getMainBall() {
        return mainBall;
    }

    public Gun getGun() {
        return gun;
    }

    public void keyPressed(KeyEvent e) {
        // When the up arrow is pressed, shoot out mini balls
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if(gun.isCanShoot()) {
                    miniBall.setX(gun.getX());
                    miniBall.setY(gun.getY() + 10);
                    miniBall.setOnScreen(true);
                    gun.setCanShoot(false);
                }
                break;
        }
        // Redraw the window
        window.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isGameStarted) {
            // Movement of the main Ball, guns and the mini balls
            mainBall.move();
            gun.move();
            gun.bounce(25, 550);
            if (miniBall.isOnScreen()) {
                miniBall.move();
            }

            // When the mini ball gets to the other side reload
            if (miniBall.getX() == 50) {
                miniBall.setOnScreen(false);
                gun.setCanShoot(true);
            }
            // Set the mini ball where the gun is
            if (gun.isCanShoot()) {
                miniBall.setX(gun.getX() - 2 * miniBall.getRadius());
                miniBall.setY(gun.getY() + 10);
            }

            // Action of the user's choice of level
            if (easy) {
                easyLevel();
            }

            else if (hard) {
                hardLevel();
            }

            else if(extreme){
                extremeLevel();
            }

            // When either the user of the computer wins
            if (mainBall.getX() <= userWinsX) {
                gameOver = true;
                winner = "You win!";

            }
            else if (mainBall.getX() >= computerWinsX) {
                gameOver = true;
                winner = "The Computer";
            }
            // Redraw the window
            window.repaint();
        }
    }
    // Code for the easy level
    public void easyLevel(){
        // Guns movement
        comGun.move();
        comGun.bounce(25, 550);

        // Generate when the mini balls are released
        if (comMiniBall.canBeMoved()) {
            comGun.setCanShoot(false);
        }
        if (!(comGun.isCanShoot())) {
            comMiniBall.move();
        } else if (comGun.isCanShoot()) {
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }
        // Reload the mini ball at gun's position
        if (comMiniBall.getX() >= 750) {
            comGun.setCanShoot(true);
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }

    }
    // Code for the hard level
    public void hardLevel(){
        // Movement of the computer's gun
        comGun.move();
        comGun.bounce(25, 550);
        // Range of when the computer shoots
        if (!(comGun.getY() > 300) && !(comGun.getY() < 270)) {
            comGun.setCanShoot(false);
        }
        if (!(comGun.isCanShoot())) {
            comMiniBall.move();
        } else if (comGun.isCanShoot()) {
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }
        // Reload the mini ball at gun's position
        if (comMiniBall.getX() >= 750) {
            comGun.setCanShoot(true);
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }
    }
    // Code for the extreme level
    public void extremeLevel(){
        // For the beginning make the guns and user's mini balls to move faster
        if (rounds == 0){
            comGun.setDy(9);
            gun.setDy(9);
            miniBall.addDX(-7);
        }
        rounds++;
        // Movement of the computer's gun
        comGun.move();
        comGun.bounce(25, 550);

        // Range of when the computer shoots
        if (!(comGun.getY() > 300) && !(comGun.getY() < 270)) {
            comGun.setCanShoot(false);
        }
        if (!(comGun.isCanShoot())) {
            comMiniBall.move();
        } else if (comGun.isCanShoot()) {
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }
        // Reload the mini ball at gun's position
        if (comMiniBall.getX() >= 750) {
            comGun.setCanShoot(true);
            comMiniBall.setX(comGun.getX() + 100);
            comMiniBall.setY(comGun.getY() + 10);
        }
    }

    public void mousePressed(MouseEvent e) {
        // Want to play easy
        if(e.getX() > MINEASY && e.getX() < MAXEASY){
            easy = true;
            hard = false;
            extreme = false;
            // Change the background
            isAtIntro = false;
        }
        // Want to play hard
        else if (e.getX() < MAXHARD && e.getX() > MINHARD){
            easy = false;
            hard = true;
            extreme = false;
            // Change the background
            isAtIntro = false;
        }
        // Want to play extreme
        else if(e.getX() < MAXEXTREME && e.getX() > MINEXTREME){
            easy = false;
            hard = false;
            extreme = true;
            // Change the background
            isAtIntro = false;
        }
        // Redraw the window
        window.repaint();
    }

    // Methods required from KeyListener, the Mouse Listener and Mouse Motion Listener
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        // Start a new game
        Game game = new Game();
    }
}