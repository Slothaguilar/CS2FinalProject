import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    private boolean isGameOver;
    private static final int DELAY_IN_MILLISEC = 20;
    private GameViewer window;
    private int wins;
    private int rounds;
    private Ball mainBall;
    private Gun gun;
    private MiniBall miniBall;
    private String winner;
    private boolean gameOver;


    public Game() {
        // Initialize Squares in the board

        gun = new Gun();
        miniBall = new MiniBall(gun);
        mainBall = new Ball(miniBall);

        window = new GameViewer(this, mainBall);
        rounds = 0;
        gameOver = false;

        window.addKeyListener(this);

        // Initialize winning stats variables
        this.isGameOver = false;
        this.winner = "";


        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        Timer clock = new Timer(DELAY_IN_MILLISEC, this);

        // Now actually start the timer.
        clock.start();

    }
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to BoardGame!");


        window.repaint();

    }

    public int getRounds() {
        return rounds;
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

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                gun.setMoving(false);
                if(gun.isCanShoot()) {
                    miniBall.setX(gun.getX());
                    miniBall.setY(gun.getY() + 10);
                    miniBall.setOnScreen(true);
                    gun.setCanShoot(false);
                }
                break;
        }
        window.repaint();
    }

    public Ball getMainBall() {
        return mainBall;
    }

    public Gun getGun() {
        return gun;
    }

    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
        gun.setMoving(true);

        window.repaint();
    }
    public void actionPerformed(ActionEvent e) {		// NEW #5 !!!!!!!!!!

            mainBall.move();
            // if the mini ball "touches" or has the same x and y then disapear the mini balls and move the main Ball
            mainBall.bounce(50, 750, 50, 500);

            if (gun.isMoving()) {
                gun.move();
                gun.bounce(25, 550);
            }

            if (miniBall.isOnScreen()) {
                miniBall.move();
            }
            if (miniBall.getX() == 50) {
                miniBall.setOnScreen(false);
                gun.setCanShoot(true);
            }

            //System.out.println(mainBall.getX());
            if (mainBall.getX() <= 50) {
                gameOver = true;
                winner = "Player 1";

            }
            window.repaint();

    }

    public void mousePressed(MouseEvent e) {
        // Change the background
        rounds++;
        window.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // For demo purposes only

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // For demo purposes only

    }
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
