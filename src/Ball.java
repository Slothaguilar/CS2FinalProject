import java.awt.Color;
import java.awt.Graphics;
public class Ball {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;
    private MiniBall miniBall;
    private MiniBall comMiniBall;


    public Ball(MiniBall miniBall, MiniBall comMiniBall) {
        x = 368;
        y = 270;
        dx = 2;
        dy = 2;
        radius = 30;
        color = Color.GREEN;
        this.miniBall= miniBall;
        this.comMiniBall = comMiniBall;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }
    public void move() {
        if (x <= miniBall.getX() && miniBall.getX() <= x + 2*radius){
            if (!(miniBall.getY() > 330)){
                if (!(miniBall.getY() + (miniBall.getRadius() *2) < y)){
                    x = x - dx;
                }
            }
        }



        if (x <= comMiniBall.getX() && comMiniBall.getX() <= x + 2*radius){
            if (!(comMiniBall.getY() > 330)){
                if (!(comMiniBall.getY() + (comMiniBall.getRadius() *2) < y)){
                    x = x + dx;
                }
            }
        }

    }


}






