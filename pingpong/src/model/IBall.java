package model;

/**
 * Created by hugolundin on 2017-03-01.
 */
public interface IBall {
    void setBounds(int screenWidth, int screenHeight);
    void move(Racket racket, Score score);
    int getY();
    int getX();
    int getWidth();
}
