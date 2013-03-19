/**
 *
 * @package controller
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource Controller.java
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import model.Ball;
import model.Level;
import model.Racket;
import model.Score;
import view.ButtonPanel;
import view.ScreenPanel;

public class Controller {

    /**
     * constructs a Controller
     *
     * @access public
     *
     * @param buttonPanel - a panel holding the buttons
     * @param screenPanel - a panel holding the screen
     * @param ball - the ball, an object of Ball
     * @param racket - the racket, an object of Racket
     * @param score - the game score, an object of Score
     * @param level - the game level, an object of Level
     * @author Tafadzwa Gonera
     */
    public Controller(ButtonPanel buttonPanel,
            ScreenPanel screenPanel,
            Ball ball,
            Racket racket,
            Score score,
            Level level) {
        this.buttonPanel = buttonPanel;
        this.screenPanel = screenPanel;
        this.ball = ball;
        this.racket = racket;
        this.score = score;
        this.level = level;
        initDelay = 1500;
        delay = 35;
        initComponents();
    }

    /**
     * initializes components and values
     *
     * @access private
     *
     * @author Tafadzwa Gonera
     */
    private void initComponents() {
        previousLevel = level.getLevel();
        screenWidth = screenPanel.getWidth();
        screenHeight = screenPanel.getHeight();
        buttonPanel.addStartGameListener(new StartGameHandler());
        screenPanel.addRacketMoveListener(new RacketMoveHandler());
        moveBall();
    }

    /**
     * starts or pauses the game when the startPause button
     * is clicked
     * 
     * @access private
     *
     * @author Tafadzwa Gonera
     */
    private class StartGameHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            boolean start;
            start = buttonPanel.getStart();
            if (start) {
                timer.setInitialDelay(initDelay);
                timer.start();
                screenPanel.addNotify();
                buttonPanel.update();
                buttonPanel.setBtnStartPauseText("Pause");
            } else {
                buttonPanel.setBtnStartPauseText("Start");
                timer.stop();
            }
        }
    }

    /**
     * moves the racket according to the key pressed on the keyboard
     *
     * @access private
     *
     * @author Tafadzwa Gonera
     */
    private class RacketMoveHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent evt) {
            racket.setBounds(screenWidth, screenHeight);
            racket.move(evt, ball);
            screenPanel.repaint();
        }
    }

    /**
     * adjusts the speed of the ball according to the current level
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void setDelay() {
        currentLevel = level.getLevel();
        if (previousLevel < currentLevel) {
            if (delay > MIN_DELAY) {
                delay -= 5;
                //System.out.println(delay);
                timer.setDelay(delay);
            }
        }
        previousLevel = currentLevel;
    }

    /**
     * moves the ball across the screen
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void moveBall() {
        timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ball.setBounds(screenWidth, screenHeight);
                ball.move(racket, score);
                setDelay();
                screenPanel.repaint();
            }
        });
    }
    /**
     * @var MIN_DELAY - the number of milliseconds between each individual
     * movement of the ball in x or y direction
     *
     * @access private
     */
    private final static int MIN_DELAY = 15;
    /**
     * @var buttonPanel - a panel holding all the buttons
     *
     * @access private
     */
    private ButtonPanel buttonPanel;
    /**
     * @var screenPanel - a panel holding the screen
     *
     * @access private
     */
    private ScreenPanel screenPanel;
    /**
     * @var racket - the racket, an object of Racket
     *
     * @access private
     */
    private Racket racket;
    /**
     * @var score - the score of a player, an object of Score
     *
     * @access private
     */
    private Score score;
    /**
     * @var timer - an object of Timer
     *
     * @access private
     */
    private Timer timer;
    /**
     * @var level - the level of the game, an object of Level
     *
     * @access private
     */
    private Level level;
    /**
     * @var ball - the ball, an object of Ball
     *
     * @access private
     */
    private Ball ball;
    // the current number milliseconds between each 
    // individual movement of the ball in x or y direction
    private int delay,
            // the current level of the player
            currentLevel,
            // the previous level 
            previousLevel,
            // the width of the panel creating the screen
            screenWidth,
            // the height of the panel creating the screen
            screenHeight,
            // the number of milliseconds it takes the ball to move
            // after a player presses "start" button
            initDelay;
}// end class