import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Ball extends Rectangle
{
    int xVelocity=0;
    int yVelocity=0;
    int yAcceleration=0;
    int initialSpeed=0;
    int initialAngle=90;
    int initialVelocity = 25;

    public Ball(int x, int y, int width, int height)
    {
        super(x,y,width,height);
        setXDirection(0);
        setYDirection(0);
    }
    public void setXDirection(int xDirection)
    {
        xVelocity = xDirection;
    }
    public void setYDirection(int yDirection)
    {
        yVelocity = yDirection;
    }
    public void setInitialVelocity(int iV)
    {
        initialVelocity = iV;
    }
    public void setInitialAngle(int iA)
    {
        initialAngle = iA;
    }
    public int getInitialVelocity()
    {
        return initialVelocity;
    }
    public int getInitialAngle()
    {
        return initialAngle;
    }

    //Repeatedly change location using velocity.
    //Repleatedly change vertical velocity creating
    //downward acceleration
    public void move()
    {
        x += xVelocity;
        y += yVelocity;
        yVelocity+=yAcceleration;
    }

    //Draws the ball and the little line that indicates the direction.
    //Also the value of the angle and the value of the
    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
        //Not sure this is a good place to draw.  Feels like it should all
        //be in score, but put it here for now....
        g.drawString("velocity: "+initialVelocity, 5,70);
        g.drawString("angle: "+initialAngle, 5,80);
        g.drawLine(10,544,10+(int)(Math.cos(Math.toRadians(initialAngle))*20),544-(int) (Math.sin(Math.toRadians(initialAngle))*20));
    }


    //Increase and decrease the angle and the velocity.
    //Frances discovered you can "launch" while the ball
    //is in the air.  Looks like a flappy-bird or the beginning
    //of a platformer game
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            initialAngle--;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            initialAngle++;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            initialVelocity++;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            initialVelocity--;
        }
        if (e.getKeyCode() == KeyEvent.VK_L)
        {
            Score.setMiss(false);
            Score.setHit(false);
            yAcceleration = 1;
            setXDirection((int)(Math.cos(Math.toRadians(initialAngle))*initialVelocity));
            setYDirection((int) (Math.sin(Math.toRadians(initialAngle))*initialVelocity)*(-1));
        }
    }

}
