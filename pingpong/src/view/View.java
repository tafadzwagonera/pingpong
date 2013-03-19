/**
 *
 * @package view
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource View.java
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {

     /**
     * constructs a view
     *
     * @access public
     *
     * @param buttonPanel - a panel holding the buttons
     * @param screenPanel - a panel holding the screen
     * @param frameTitle - a string representing the title of the window
     * @author Tafadzwa Gonera
     */
    public View(ButtonPanel buttonPanel, ScreenPanel screenPanel, String frameTitle) {
        super(frameTitle);
        this.buttonPanel = buttonPanel;
        this.screenPanel = screenPanel;
    }

    /**
     * adds components to the View
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    private void addComponentsToPane(Container pane) {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(screenPanel, BorderLayout.SOUTH);
        pane.add(mainPanel);
    }

    /**
     * centers the window of the game
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        width = (int) (screenSize.width - frameSize.width) / 2;
        height = (int) (screenSize.height - frameSize.width) / 2;
        setLocation(width, height / 2);
        setLocationRelativeTo(null);
    }

    /**
     * creates and displays the game
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setResizable(false);
        setSize(300, 200);
        center();
        setVisible(true);
        pack();
    }
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
     * @var mainPanel - a panel holding the buttonPanel and screenPanel
     *
     * @access private
     */
    private JPanel mainPanel;
    // the width and height of the centered window in pixels
    private int width, height;
}