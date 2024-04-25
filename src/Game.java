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


    public Game() {
        // Initialize Squares in the board
        mainBall = new Ball();
        gun = new Gun();

        window = new GameViewer(this, mainBall);
        rounds = 0;

        window.addKeyListener(this);

        // Initialize winning stats variables
        this.isGameOver = false;
        this.winner = "";

        Timer clock = new Timer(DELAY_IN_MILLISEC, this);

        // Now actually start the timer.
        clock.start();

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);


    }
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to BoardGame!");

        window.repaint();

    }
    public boolean checkWin(){
        return false;
    }

    public int getRounds() {
        return rounds;
    }
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                gun.setCenter(5, 5);
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
    }
    public void actionPerformed(ActionEvent e) {		// NEW #5 !!!!!!!!!!

        // TODO: modify this to call move() and bounce() on all 100 Balls.
        gun.move();

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
