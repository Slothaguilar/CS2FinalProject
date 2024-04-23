import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private boolean isGameOver;
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

        window = new GameViewer(this, mainBall);
        rounds = 0;

        window.addKeyListener(this);

        // Initialize winning stats variables
        this.isGameOver = false;
        this.winner = "";


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

    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
