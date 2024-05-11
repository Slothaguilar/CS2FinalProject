import java.awt.*;

/**
 * Gun
 * Written by Sofia Aguilar on May 10, 2024
 *
 * Gun this for the user or the computer to compete,shoots out mini balls, and move up and down.
 */
public class Gun  {
    private int x;              // Center x
    private int y;              // Center y
    private int dy;             // Delta y in one time unit
    private boolean canShoot;   // When the gun can shoot

    // Width and height of gun
    private final int width = 100;
    private final int height = 50;
    private Color color;    // Color of the gun


    public Gun(int x, int y, Color color) {
        // Initializing the instance variables
        this.x = x;
        this.y = y;
        canShoot = true;
        this.color = color;
        dy = 4;
    }

    public void draw(Graphics g) {
        // Drawing the gun
        g.setColor(color);
        g.drawRect(x,y, width,height);
        g.fillRect(x,y,width,height);

    }
    // Getters and Setters
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

    public void setDy(int dy) {
        this.dy =this.dy + dy;
    }

    // The movement of the gun
    public void move() {
        y = y + dy;

    }
    // Making the gun go up and down
    public void bounce(int yLow, int yHigh) {
        if ((y - width <= yLow && dy < 0) || (y + width >= yHigh && dy > 0)) {
            dy = -dy;
        }
    }
}