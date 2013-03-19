/**
 *
 * @package model
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v
 * @filesource Racket.java
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Racket {

    /**
     * constructs a Racket
     *
     * @access public
     *
     * @param x - the x coordinate of the racket
     * @param y - the y coordinate of the racket
     * @param width - the width of the racket in pixels
     * @param height - the height of the racket in pixels
     * @author Tafadzwa Gonera
     */
    public Racket(int x, int y, int width, int height) {
        this.height = height;
        this.width = width;
        leftEdge = 0;
        this.x = x;
        this.y = y;
        dx = 5;
    }

    /**
     * calculates the width and height of the screen in which the racket is
     * permitted to move
     *
     * @access public
     *
     * @param screenWidth - the width of the screen
     * @param screenHeight - the height of the screen
     * @author Tafadzwa Gonera
     */
    public void setBounds(int screenWidth, int screenHeight) {
        rightEdge = screenWidth - width;
        bottomEdge = screenHeight;
    }

    /**
     * animates the racket i.e moves it left or right when a key is pressed on
     * the keyboard and identifies any contact made with the ball
     *
     * @access public
     *
     * @param evt - a key event, an object of Key event
     * @param ball - the ball, an object of Ball
     * @author Tafadzwa Gonera
     */
    public void move(KeyEvent evt, Ball ball) {
        int kCode, bWidth, bX, bY;

        kCode = evt.getKeyCode();
        bWidth = ball.getWidth();
        bX = ball.getX();
        bY = ball.getY();

        if (kCode == KeyEvent.VK_LEFT) {

            //  if beyond the right edge of the ball stop the racket from moving
            if (bY + bWidth == bottomEdge && x <= bX + bWidth) {
                dx = 0;
            }

            //  if beyond the left screen edge place the racket against that edge
            if (x < leftEdge) {
                setLocation(leftEdge, y);
            }

            // else move the racket to the left at the given velocity.        
            setLocation(x - dx, y);

        } else if (kCode == KeyEvent.VK_RIGHT) {

            //  if beyond the left edge of the ball stop the racket from moving
            if (bY + bWidth == bottomEdge && x + width >= bX) {
                dx = 0;
            }

            //  if beyond the right screen edge place the racket against that edge
            if (x > rightEdge) {
                setLocation(rightEdge, y);
            }

            // else move the racket to the right at the given velocity.            
            setLocation(x + dx, y);
        }
    }

    /**
     * draws the Racket on the screen
     *
     * @access public
     *
     * @param g - a Graphics object
     * @author Tafadzwa Gonera
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    /**
     * returns the x coordinate of the racket's location on the screen
     *
     * @access public
     *
     * @return integer - x coordinate of the racket's location in pixels
     * @author Tafadzwa Gonera
     */
    public int getX() {
        return x;
    }

    /**
     * returns the y coordinate of the racket's location on the screen
     *
     * @access public
     *
     * @return integer - y coordinate of the racket's location in pixels
     * @author Tafadzwa Gonera
     */
    public int getY() {
        return y;
    }

    /**
     * returns the width of the racket in pixels
     *
     * @access public
     *
     * @return integer - the width of the racket in pixels
     * @author Tafadzwa Gonera
     */
    public int getWidth() {
        return width;
    }

    /**
     * move the racket to a particular location on the screen
     *
     * @access public
     *
     * @param x - x coordinate of the racket's location in pixels
     * @param y - y coordinate of the racket's location in pixels
     * @author Tafadzwa Gonera
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // the x coordinate of the racket in pixels
    private int x,
            // the y coordinate of the racket in pixels
            y,
            // the width of the racket in pixels
            width,
            // the height of the racket in pixels
            height,
            // the right edge of the screen in pixels
            rightEdge,
            // the left edge of the screen in pixels
            leftEdge,
            // the bottom edge of the screen in pixels
            bottomEdge,
            // a change in the x coordinate of the racket in pixels
            dx;
}// end class