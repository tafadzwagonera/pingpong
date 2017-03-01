/**
 *
 * @package model
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource Ball.java
 */
package model;

import java.awt.Graphics;

public class Ball implements IBall, Drawable {

    private final static int DIAMETER = 21;

    // Coordinates of the ball
    private int x;
    private int y;

    // Change in x-coordinate of ball in pixels
    private int dx;

    // Change in y-coordinate of ball in pixels
    private int dy;

    // Screen edges in pixels
    private int rightEdge;
    private int bottomEdge;
    private int topEdge;
    private int leftEdge;
    
    public Ball(int x, int y, int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.x = x;
        this.y = y;
        topEdge = leftEdge = 0;
    }

    /**
     * calculates the width and height of the screen in which
     * the ball is permitted to move
     * 
     * @access public
     *
     * @param screenWidth - the width of the screen
     * @param screenHeight - the height of the screen
     * @author Tafadzwa Gonera
     */
    public void setBounds(int screenWidth, int screenHeight) {
        rightEdge = screenWidth - DIAMETER;
        bottomEdge = screenHeight - DIAMETER;
    }

    /**
     * animates the ball i.e moves it across the screen when
     * the game is started and identifies any contact made
     * with the racket
     *
     * @access public
     *
     * @param racket - the racket, an object of Racket
     * @param score - the game score, an object of Score
     * @author Tafadzwa Gonera
     */
    public void move(Racket racket, Score score) {
        int rWidth, rX, rY;

        rWidth = racket.getWidth();
        rX = racket.getX();
        rY = racket.getY();

        // move the ball at the given velocity.
        x += dx;
        y += dy;
        if (x < leftEdge) {

            // place against the left screen edge
            x = leftEdge;

            // bounce the ball off the left screen edge by reversing the direction          
            dx = -dx;
        } else if (x > rightEdge) {

            // place against the right screen edge
            x = rightEdge;

            // bounce the ball off the right screen edge by reversing the direction
            dx = -dx;
        }

        if (y < topEdge) {

            // place against the top screen edge
            y = topEdge;

            // bounce the ball off the top screen edge by reversing the direction
            dy = -dy;
        } else if (y > bottomEdge) {

            // place against the bottom screen edge
            y = bottomEdge;

            // stop the ball from moving along the bottom screen edge
            dx = 0;
        }

        // if ball makes contact with racket 
        if (y + DIAMETER == rY && x + DIAMETER >= rX && x <= rX + rWidth) {

            // bounce the ball off the top edge of the racket by reversing the direction  
            dy = -dy;
            score.raiseScore();
        }
    }

    /**
     * draws the Ball on the screen
     *
     * @access public
     *
     * @param g - a Graphics object
     * @author Tafadzwa Gonera
     */
    public void draw(Graphics g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    /**
     * returns the x coordinate of the ball's location on the screen
     *
     * @access public
     *
     * @return integer - x coordinate of the ball's location in pixels
     * @author Tafadzwa Gonera
     */
    public int getX() {
        return x;
    }

   /**
     * returns the y coordinate of the ball's location on the screen
     *
     * @access public
     *
     * @return integer - y coordinate of the ball's location in pixels
     * @author Tafadzwa Gonera
     */
    public int getY() {
        return y;
    }
    
    /**
     * returns the width of the ball in pixels
     *
     * @access public
     *
     * @return integer - the diameter of the ball in pixels
     * @author Tafadzwa Gonera
     */
    public int getWidth() {
        return DIAMETER;
    }

}