import java.awt.Color;
import java.awt.Graphics;

/**
 * MiniBall
 * Written by Sofia Aguilar on May 10, 2024
 *
 * MiniBall creates mini ball for the computer and the user,can help move the ball in the middle to move, and moves the left por right.
 */
public class MiniBall {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // Delta x in one time unit
    private int radius;         // Radius of the ball
    private Color color;        // Color of the mini balls
    private boolean isOnScreen; // If the mini ball is on the screen

    public MiniBall(int x, int y, int dx, Color color) {
        // Initializing the instance variables
        this.dx = dx;
        radius = 10;
        this.color = color;
        this. x = x;
        this.y = y;
        // For the intro make the mini ball not show up
        isOnScreen = false;
    }
    // Getters and Setters
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

    public int getDx() {
        return dx;
    }
    public boolean isOnScreen() {
        return isOnScreen;
    }

    public void setOnScreen(boolean onScreen) {
        isOnScreen = onScreen;
    }

    // Make the mini balls move faster
    public void addDX(int dx){
        this.dx =this.dx + dx;

    }
    // Draw out the mini balls
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }
    // Mini ball's movement
    public void move() {
        x = x + dx;

    }
    // Generate when the computer's balls can be released
    public boolean canBeMoved(){
        double random = (Math.random()*2);
        // If higher or equal to one then don't shoot
        if(random >= 1){
            return false;
        }
        return true;
    }
}