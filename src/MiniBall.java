import java.awt.Color;
import java.awt.Graphics;
public class MiniBall {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;

    public MiniBall() {
        x = 0;
        y = 5;
        dx = 12;
        dy = 13;
        radius = 10;
        color = Color.BLUE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean bounce(int xLow, int xHigh, int yLow, int yHigh) {
        return true;
    }

    public void draw(Graphics g) {

    }
}
