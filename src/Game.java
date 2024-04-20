public class Game
{
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
        window = new GameViewer(this);

        // Initialize winning stats variables
        this.isGameOver = false;
        this.winner = "";

    }
    public void run() {

    }
    public boolean checkWin(){
        return false;
    }
    public static void main(String[] args) {

    }
}
