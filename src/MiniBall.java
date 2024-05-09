import java.awt.Color;
import java.awt.Graphics;
public class MiniBall {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;
    private boolean isOnScreen;
    private Gun gun;
    private int x2;              // Center x
    private int y2;

    public MiniBall(Gun gun, int x, int y, int dx, Color color) {
        this.dx = dx;
        dy = 5;
        radius = 10;
        this.color = color;
        isOnScreen = false;
        this.gun = gun;
        this. x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }
    public void move() {
        x = x + dx;

    }
    public void addDX(int dx){
        this.dx =this.dx + dx;

    }

    public int getDx() {
        return dx;
    }

    public void bounce(int xLow, int xHigh, int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((x - radius <= xLow && dx < 0) || (x + radius >= xHigh && dx > 0)) {
            dx = -dx;
        }

        // Now check for a y bounce.
        if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0)) {
            dy = -dy;
        }
    }

    public boolean isOnScreen() {
        return isOnScreen;
    }

    public void setOnScreen(boolean onScreen) {
        isOnScreen = onScreen;
    }

    public boolean canBeMoved(){
        double random = (Math.random()*2);

        if(random >= 1){
            return false;
        }

        return true;
    }
}
