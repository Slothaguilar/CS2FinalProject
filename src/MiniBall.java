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

    public MiniBall(Gun gun) {
        dx = 5;
        dy = 5;
        radius = 10;
        color = Color.BLUE;
        isOnScreen = false;
        this.gun = gun;
        x = gun.getX();
        y = gun.getY();
        x2 = gun.getX2();
        y2 = gun.getY2();
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

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getRadius() {
        return radius;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }
    public void move() {
        x = x - dx;

        x2 = x2 + dx;

    }

    public boolean isOnScreen() {
        return isOnScreen;
    }

    public void setOnScreen(boolean onScreen) {
        isOnScreen = onScreen;
    }
}
