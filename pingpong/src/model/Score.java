/**
 *
 * @package model
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v
 * @filesource Score.java
 */

package model;

public final class Score {

    // private constructor prevents instantiation from other classes
    private Score() {
    }

    /**
     * returns a sole instance of Score
     *
     * @access public
     *
     * @return Level - a sole instance of Score class
     *
     * @author Tafadzwa Gonera
     */
    public static Score getInstance() {
        return SCORE;
    }

    /**
     * returns the current score of a player
     *
     * @access public
     *
     * @return integer - the current score of a player
     *
     * @author Tafadzwa Gonera
     */
    public int getScore() {
        return currentScore;
    }

    /**
     * increases the current score of a player
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void raiseScore() {
        currentScore += 10;

        // prevents the level from being raised when a player
        // starts a game
        if (flag) {
            if (currentScore % 20 == 0) {
                Level.setLevel();
            }
        }
        flag = true;
    }

    /**
     * sets the initial score of a player
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void setScore() {
        currentScore = 0;
        flag = false;
    }
    /**
     * @var SCORE - an object of Score
     *
     * @access private
     */
    private final static Score SCORE = new Score();
    /**
     * @var currentScore - the current score
     *
     * @access private
     */
    private static int currentScore;
    /**
     * @var flag - a variable to prevent the level from being
     * raised when a player starts a game
     *
     * @access private
     */
    private static boolean flag;
}
