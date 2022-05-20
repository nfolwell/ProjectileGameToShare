/**
 * Sets up most of the action in the JFrame.  The size is set, for the
 * widow size (this is the JPanel?), the size of the ball and the size
 * of the Target are set here too.
 * The game "loop" is set up here too.
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable
{
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.55555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 10;
    static final int TARGET_WIDTH = 40 ;
    static final int TARGET_HEIGHT = 10;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Target target;
    Ball ball;
    Score score;

    public GamePanel()
    {

        newTarget();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);


        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        int initXLoc = 10;
        int initYLoc = GAME_HEIGHT - BALL_DIAMETER - 1;
        int tempInitVel = 25;
        int tempInitAngle = 90;
        if (ball!=null)
        {
            tempInitVel = ball.getInitialVelocity();
            tempInitAngle = ball.getInitialAngle();
        }

        ball = new Ball(initXLoc,initYLoc,BALL_DIAMETER,BALL_DIAMETER);

        ball.setInitialVelocity(tempInitVel);
        ball.setInitialAngle(tempInitAngle);

    }

    public void newTarget()
    {
        target = new Target(GAME_WIDTH-3*TARGET_WIDTH,GAME_HEIGHT-TARGET_HEIGHT,TARGET_WIDTH,TARGET_HEIGHT);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g) {
        target.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move()
    {
        //target.move();
        ball.move();
    }

    public void checkCollision()
    {
        //The ball hit the ground.  That's a miss!
        if (ball.y >= GAME_HEIGHT)
        {
            newTarget();
            newBall();
            Score.setMiss(true);
        }
        //Hit the target! Increase score.  Reset.  Report new score!
        if (ball.intersects(target))
        {
            score.player++;
            newTarget();
            newBall();
            Score.setHit(true);
        }
    }


    public void run()
    {
        //game loop
        long  lastTime = System.nanoTime();
        double amountOfTicks = 30.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;

        while(true)
        {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1)
            {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            ball.keyPressed(e);
        }
    }
}
