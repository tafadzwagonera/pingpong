/**
 *
 * @package model
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource Level.java
 */
package model;

final public class Level {

    // private constructor prevents instantiation from other classes
    private Level() {
    }

    /**
     * returns a sole instance of Level
     *
     * @access public
     *
     * @return Level - a sole instance of Level class
     *
     * @author Tafadzwa Gonera
     */
    public static Level getInstance() {
        return LEVEL;
    }

    /**
     * returns the current level of the game
     *
     * @access public
     *
     * @return integer - the current level of the game
     *
     * @author Tafadzwa Gonera
     */
    public int getLevel() {
        return currentLevel;
    }

    /**
     * increases the level of the game
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public static void setLevel() {
        if (currentLevel < MAX_LEVEL) {
            currentLevel++;
        }
    }
    /**
     * @var LEVEL - an object of Level
     *
     * @access private
     */
    private final static Level LEVEL = new Level();
    /**
     * @var MAX_LEVEL - the maximum number permissible of levels 
     *
     * @access private
     */
    private final static int MAX_LEVEL = 5;
    /**
     * @var currentLevel - the current level
     *
     * @access private
     */
    private static int currentLevel = 0;
}
