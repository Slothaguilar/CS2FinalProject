import java.awt.*;

public class Gun  {
    private int x;              // Center x
    private int y;// Center y
    private int x2;              // Center x
    private int y2;
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int angle;
    private boolean canShoot;
    private final int width = 100;
    private final int height = 50;
    private boolean isMoving;


    public Gun() {
        x = 650;
        y = 50;
        x2 = 50;
        y2 = 50;
        dx = 2;
        dy = 2;
        angle = 0;
        isMoving = true;
        canShoot = true;

    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        //g.fillOval(250, 100, 5, 5);

        g.drawRect(x,y, width,height);
        g.fillRect(x,y,width,height);

        g.setColor(Color.ORANGE);
        g.drawRect(x2,y2, width,height);
        g.fillRect(x2,y2,width,height);

    }
    public void setCenter(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }
    public void move() {
        y = y + dy;

        y2 = y2 + dy;

    }
    public void bounce(int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        // Now check for a y bounce.
        if ((y - width <= yLow && dy < 0) || (y + width >= yHigh && dy > 0)) {
            dy = -dy;
        }

    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
