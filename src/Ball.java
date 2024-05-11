import java.awt.Color;
import java.awt.Graphics;

/**
 * Ball
 * Written by Sofia Aguilar on May 10, 2024
 *
 * Ball creates a Ball for the game that moves side to side when touched by mini balls.
 */
public class Ball {
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // Delta x in one time unit
    private int radius;         // Radius of the ball
    private Color color;        // Color of the ball

    // Coordinates for the start
    private int startX = 368;
    private int startY = 270;
    private int lowOfMainBall = 330;

    // Connect to the miniBalls
    private MiniBall miniBall;
    private MiniBall comMiniBall;

    public Ball(MiniBall miniBall, MiniBall comMiniBall) {
        // Initializing the instance variables
        x = startX;
        y = startY;
        dx = 2;
        radius = 30;
        color = new Color(94, 245, 97);
        this.miniBall= miniBall;
        this.comMiniBall = comMiniBall;
    }
    // Getter method
    public int getX() {
        return x;
    }

    // Drawing the main ball
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);

    }
    // The main ball's movement when it is pushed by a mini ball
    public void move() {
        // Check if user's miniball hit main ball
        if (x <= miniBall.getX() && miniBall.getX() <= x + 2*radius && !(miniBall.getY() > lowOfMainBall) && !(miniBall.getY() + (miniBall.getRadius() *2) < y)){
            // If on the extreme level make the ball move farther
            if(miniBall.getDx()<-5){
                x=x-(2*dx);
            }
            else{
                x = x - dx;
            }
        }
        // Check if computer's mini ball hit main ball
        if (x <= comMiniBall.getX() && comMiniBall.getX() <= x + 2*radius && !(comMiniBall.getY() > lowOfMainBall) && !(comMiniBall.getY() + (comMiniBall.getRadius() *2) < y)){
            x = x + dx;
        }
    }
}