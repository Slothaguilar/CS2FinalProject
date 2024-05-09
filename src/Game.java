import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    // levels
    private boolean easy;
    private boolean hard;
    private boolean extreme;
    private int counter;

    private boolean go;

    private static final int DELAY_IN_MILLISEC = 20;
    private GameViewer window;
    private int rounds;
    private Ball mainBall;
    private Gun gun;
    private MiniBall miniBall;

    private Gun comGun;
    private MiniBall comMiniBall;
    private String winner;
    private boolean gameOver;


    public Game() {
        // Initialize Squares in the board
        go = false;
        // user
        gun = new Gun(650,50, Color.BLUE);
        Color color = new Color(56, 73, 220);
        miniBall = new MiniBall(gun, gun.getX(), gun.getY(), -5, color);

        // computer
        comGun = new Gun(50,50, Color.ORANGE);
        Color color1 = new Color(236, 147, 57);
        comMiniBall = new MiniBall(comGun, comGun.getX(), comGun.getX(), 7, color1);

        mainBall = new Ball(miniBall, comMiniBall);

        window = new GameViewer(this, mainBall);
        rounds = 0;
        gameOver = false;

        window.addKeyListener(this);

        // Initialize winning stats variables
        this.winner = "";
        this.counter = 0;


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

    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public int getRounds() {
        return rounds;
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

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                //gun.setMoving(false);
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

        if (go) {
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
            if (gun.isCanShoot()) {
                miniBall.setX(gun.getX() - 2 * miniBall.getRadius());
                miniBall.setY(gun.getY() + 10);
            }


            if (mainBall.getX() <= 168) {
                gameOver = true;
                winner = "You win!";

            }
            if (mainBall.getX() >= 565) {
                gameOver = true;
                winner = "The Computer";
            }

            // TODO: code when the computer would realse their mini ball
            // computer gun moving

            if (easy) {

                comGun.move();
                comGun.bounce(25, 550);

                if (comMiniBall.canBeMoved()) {
                    comMiniBall.move();
                    comGun.setCanShoot(false);
                }
                if (comMiniBall.getX() >= 750) {
                    comGun.setCanShoot(true);
                    comMiniBall.setX(comGun.getX() + 100);
                    comMiniBall.setY(comGun.getY() + 10);
                } else if (comGun.isCanShoot()) {
                    comMiniBall.setX(comGun.getX() + 100);
                    comMiniBall.setY(comGun.getY() + 10);
                }
            }

            else if (hard) {
                comGun.move();
                comGun.bounce(25, 550);

                if (!(comGun.getY() > 300) && !(comGun.getY() < 270)) {
                    comGun.setCanShoot(false);
                }

                if (!(comGun.isCanShoot())) {
                    comMiniBall.move();
                } else if (comGun.isCanShoot()) {
                    comMiniBall.setX(comGun.getX() + 100);
                    comMiniBall.setY(comGun.getY() + 10);
                }
                if (comMiniBall.getX() >= 750) {
                    comGun.setCanShoot(true);
                    comMiniBall.setX(comGun.getX() + 100);
                    comMiniBall.setY(comGun.getY() + 10);
                }


            }

            else if(extreme){
                if (counter == 0){
                    comGun.setDy(9);
                    gun.setDy(9);
                    miniBall.addDX(-7);
                }
                    counter++;
                    comGun.move();
                    comGun.bounce(25, 550);

                    if (!(comGun.getY() > 300) && !(comGun.getY() < 270)) {
                        comGun.setCanShoot(false);
                    }

                    if (!(comGun.isCanShoot())) {
                        comMiniBall.move();
                    } else if (comGun.isCanShoot()) {
                        comMiniBall.setX(comGun.getX() + 100);
                        comMiniBall.setY(comGun.getY() + 10);
                    }
                    if (comMiniBall.getX() >= 750) {
                        comGun.setCanShoot(true);
                        comMiniBall.setX(comGun.getX() + 100);
                        comMiniBall.setY(comGun.getY() + 10);
                    }
            }

            // boolean to decide to move the ball or to follow the gun

            // decide when it becomes true and when it becomes false


            // with math.random between 0 and 2
            // if it is less than 1 then dont
            // if greater than 1 then do realse the mini balls


            window.repaint();
        }

    }

    public void mousePressed(MouseEvent e) {
//        // Change the background
//        rounds++;

        if(e.getX() > 200 && e.getX() < 245){
            hard = false;
            easy = true;
            extreme = false;
            // Change the background
            rounds++;
        }
        // 500, 550
        else if (e.getX() < 550 && e.getX() > 500){
            easy = false;
            hard = true;
            extreme = false;
            // Change the background
            rounds++;
        }
        // 330, 420
        else if(e.getX() < 420 && e.getX() > 330){
            easy = false;
            hard = false;
            extreme = true;
            // Change the background
            rounds++;
        }

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
        //System.out.println(e.getX());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // For demo purposes only

    }
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
