import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Target extends Rectangle
{
    int id;
    int yVelocity;
    int speed = 10;

    public Target(int x, int y, int TARGET_WIDTH, int TARGET_HEIGHT)
    {
        super(x,y,TARGET_WIDTH,TARGET_HEIGHT);
        this.id = id;
    }

    public void setYDirection(int yDirection)
    {
        yVelocity = yDirection;
    }
    public void move()
    {
        y = y + yVelocity;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }

}
