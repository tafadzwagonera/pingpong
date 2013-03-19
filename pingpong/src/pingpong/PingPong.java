package pingpong;

import controller.Controller;
import model.Ball;
import model.Level;
import model.Racket;
import model.Score;
import view.ButtonPanel;
import view.ScreenPanel;
import view.View;

public class PingPong {

    public static void main(String[] args) {

        // models
        Ball ball = new Ball(130, 0, 2, 3);
        Racket racket = new Racket(110, 180, 70, 10);
        Level level = Level.getInstance();
        Score score = Score.getInstance();

        // subviews
        ScreenPanel screenPanel = new ScreenPanel(ball, racket);
        ButtonPanel buttonPanel = new ButtonPanel(score, level);

        // controller
        Controller controller = new Controller(buttonPanel,
                screenPanel,
                ball,
                racket,
                score,
                level);
        // main view                                                                            
        final View view = new View(buttonPanel, screenPanel, "Ping Pong");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                view.createAndShowGUI();
            }
        });
    }
}