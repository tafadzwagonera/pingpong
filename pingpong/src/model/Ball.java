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

public class Ball {

    /**
     * constructs a Ball
     *
     * @access public
     *
     * @param x - the x coordinate of the ball
     * @param y - the y coordinate of the ball
     * @param dx - a change in the x coordinate of a ball
     * @param dy - a change in the y coordinate of a ball
     * @author Tafadzwa Gonera
     */
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
    /**
     * @var DIAMETER - the diameter of the ball in pixels
     *
     * @access private
     */
    private final static int DIAMETER = 21;
    // the x coordinate of the ball in pixels
    private int x,
            // the y coordinate of the ball in pixels
            y,
            // a change in the x coordinate of a ball in pixels
            dx,            
            // a change in the y coordinate of a ball in pixels
            dy,
            // the right edge of the screen in pixels
            rightEdge, 
           // the bottom edge of the screen in pixels
            bottomEdge,
            // the top edge of the screen in pixels
            topEdge,
            // the left edge of the screen in pixels
            leftEdge;
}//end class