import java.awt.Color;
import java.awt.Graphics;

public class Gun  {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit

    public Gun() {
        x = 0;
        y = 5;
        dx = 12;
        dy = 13;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x - 10, y - 10, 2 * 10, 2 * 10);
    }
    public void setCenter(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

}
