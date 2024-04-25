import java.awt.Color;
import java.awt.Graphics;

public class Gun  {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit

    public Gun() {
        x = 450;
        y = 50;
        dx = 1;
        dy = 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        //g.fillOval(250, 100, 5, 5);
        g.drawRect(x,y, 20,50);
        g.fillRect(x,y,20,50);
    }
    public void setCenter(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }
    public void move() {
        x = x + dx;
        y = y + dy;
    }
    public void bounce(int xLow, int xHigh, int yLow, int yHigh) {

    }

}
