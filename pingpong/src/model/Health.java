/**
 *
 * @package model
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v
 * @filesource Health.java
 */

package model;

public final class Health {

     // private constructor prevents instantiation from other classes
    private Health() {
    }

    /**
     * returns a sole instance of Health
     *
     * @access public
     *
     * @return Level - a sole instance of Health class
     *
     * @author Tafadzwa Gonera
     */
    public static Health getInstance() {
        return HEALTH;
    }

    /**
     * returns the current health of a player
     *
     * @access public
     *
     * @return integer - the current health of a player
     *
     * @author Tafadzwa Gonera
     */
    public int getHealth() {
        return currentHealth;
    }

    /**
     * sets health of a player
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void setHealth() {
        currentHealth = MAX_HEALTH;
    }

    /**
     * decreases the health of a player
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void decrementHealth() {
        currentHealth--;
    }

    /**
     * increases the health of the player
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void incrementHealth() {
        currentHealth++;
    }
    /**
     * @var HEALT - an object of HEALTH
     *
     * @access private
     */
    private final static Health HEALTH = new Health();
    /**
     * @var MAX_HEALTH - the maximum number permissible of healths
     *
     * @access private
     */
    private final int MAX_HEALTH = 3;
    /**
     * @var currentHealth - the current health
     *
     * @access private
     */
    private int currentHealth;
}
