import java.awt.*;

public class Gun  {
    private int x;              // Center x
    private int y;// Center y
    private int x2;              // Center x
    private int y2;
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private boolean canShoot;
    private final int width = 100;
    private final int height = 50;
    private boolean isMoving;
    private Color color;


    public Gun(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        dx = 2;
        dy = 5;
        isMoving = true;
        canShoot = true;
        x2 = 50;
        y2 = 50;
        this.color = color;


    }

    public void draw(Graphics g) {
        g.setColor(color);

        g.drawRect(x,y, width,height);
        g.fillRect(x,y,width,height);

    }

    public void setDy(int dy) {
        this.dy =this.dy + dy;
    }

    public void move() {
        y = y + dy;

    }
    public void bounce(int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        // Now check for a y bounce.
        if ((y - width <= yLow && dy < 0) || (y + width >= yHigh && dy > 0)) {
            dy = -dy;
        }
//        if ((y - width < yLow && dy < 0) || (y + width > yHigh && dy > 0)) {
//            dy = -dy;
//        }


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


}
