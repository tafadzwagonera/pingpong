/**
 *
 * @package view
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource ScreenPanel.java
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import model.Ball;
import model.Racket;

public class ScreenPanel extends JPanel {

    /**
     * constructs a ScreenPanel
     *
     * @access public
     *
     * @param ball - the ball, an object of Ball
     * @param racket - the racket, an object of Racket
     * @author Tafadzwa Gonera
     */
    public ScreenPanel(Ball ball, Racket racket) {
        this.ball = ball;
        this.racket = racket;
        initComponents();
    }

    /**
     * initializes components and values
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    private void initComponents() {
        setPreferredSize(new Dimension(width, height));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * returns the width of the screen in pixels
     *
     * @access public
     *
     * @return integer - the width of the screen in pixels
     * @author Tafadzwa Gonera
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * returns the height of the screen in pixels
     *
     * @access public
     *
     * @return integer - the height of the screen in pixels
     * @author Tafadzwa Gonera
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * draws the ball and racket on the screen
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        racket.draw(g);
    }
    
    /**
     * notifies this component that it now has a parent component
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    /**
     * adds a listener that moves the racket when a key is pressed
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void addRacketMoveListener(KeyAdapter adapter) {
        this.addKeyListener(adapter);
    }
    /**
     * @var ball - the ball, an object of Ball
     *
     * @access private
     */
    private Ball ball;
    /**
     * @var racket - the racket, an object of Racket
     *
     * @access private
     */
    private Racket racket;
    // the width of the panel creating the screen
    private final int width = 300;
    // the height of the panel creating the screen
    private final int height = 200;
}
