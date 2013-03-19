/**
 *
 * @package view
 *
 * @author Tafadzwa Gonera <tafadzwagonera@gmail.com>
 * @version 1.0v
 * @since 1.0v 
 * @filesource ButtonPanel.java
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Level;
import model.Score;

public class ButtonPanel extends JPanel {

    /**
     * constructs a ButtonPanel
     *
     * @access public
     *
     * @param score - the game score, an object of Score
     * @param level - the game level, an object of Level
     * @author Tafadzwa Gonera
     */
    public ButtonPanel(Score score, Level level) {
        this.score = score;
        this.level = level;
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
        btnStartPause = new JButton("Start");
        lblUpdatedScore = new JLabel(String.valueOf(score.getScore()));
        lblUpdatedLevel = new JLabel(String.valueOf(level.getLevel()));
        lblScoreBanner = new JLabel("Score");
        lblLevelBanner = new JLabel("Level");
        calibBold16 = new Font("Callibri", Font.BOLD, SIZE);
        lblScoreBanner.setFont(calibBold16);
        lblLevelBanner.setFont(calibBold16);
        lblUpdatedScore.setFont(calibBold16);
        lblUpdatedLevel.setFont(calibBold16);
        lblScoreBanner.setForeground(RED);
        lblLevelBanner.setForeground(RED);
        lblUpdatedScore.setForeground(BLUE);
        lblUpdatedLevel.setForeground(BLUE);
        lblUpdatedScore.setOpaque(true);
        lblUpdatedLevel.setOpaque(true);
        lblUpdatedScore.setBackground(WHITE);
        lblUpdatedLevel.setBackground(WHITE);
        lblUpdatedScore.setPreferredSize(new Dimension(35, 20));
        lblUpdatedLevel.setPreferredSize(new Dimension(20, 20));
        addComponentsToPane();
    }

    /**
     * adds components to the ButtonPanel
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void addComponentsToPane() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(lblScoreBanner);
        add(lblUpdatedScore);
        add(lblLevelBanner);
        add(lblUpdatedLevel);
        add(btnStartPause);
    }

    /**
     * adds a listener that starts or pauses the game
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void addStartGameListener(ActionListener listener) {
        btnStartPause.addActionListener(listener);
    }

    /**
     * changes the text of the "startPause" button on start 
     * or pause
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void setBtnStartPauseText(String cmdString) {
        if (start) {
            btnStartPause.setText(cmdString);
            start = false;
        } else {
            btnStartPause.setText(cmdString);
            start = true;
        }
    }

    /**
     * returns a flag that denotes if the game was started or paused
     *
     * @access public
     *
     * @return boolean - true if the game was started, false otherwise 
     * @author Tafadzwa Gonera
     */
    public boolean getStart() {
        return start;
    }

    /**
     * updates the game score and level after an interval of time
     *
     * @access public
     *
     * @author Tafadzwa Gonera
     */
    public void update() {
        new Timer(UPDATE_INTERVAL, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                updatedScore = String.valueOf(score.getScore());
                lblUpdatedScore.setText(updatedScore);
                updatedLevel = String.valueOf(level.getLevel());
                lblUpdatedLevel.setText(updatedLevel);
            }
        }).start();
    }
    /**
     * @var score - the score of a player, an object of Score
     *
     * @access private
     */
    private Score score;
    /**
     * @var level - the level of the game, an object of Level
     *
     * @access private
     */
    private Level level;
    // the number of milliseconds the after updated score and level
    // labels are refreshed
    private final static int UPDATE_INTERVAL = 1000;
    // a white color
    private final static Color WHITE = Color.WHITE;
    // a blue color
    private final static Color BLUE = Color.BLUE;
    // a red color
    private final static Color RED = Color.RED;
    // the font size
    private final static int SIZE = 16;
    // a start or pause button
    private JButton btnStartPause;
    // a label for the updated score
    private JLabel lblUpdatedScore,
            // a label for the score banner
            lblScoreBanner,
            // a label for the level banner 
            lblLevelBanner,
            // a label for the updated level
            lblUpdatedLevel;
    // the default font for all label 
    private Font calibBold16;
    // the updated score and level
    private String updatedScore, updatedLevel;    
    // a flag denoting if the game was started or paused
    private boolean start = true;
}
