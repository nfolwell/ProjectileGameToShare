import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Score extends Rectangle
{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    static boolean miss = false;
    static boolean hit = false;
    int player;

    public Score(int GAME_WIDTH, int GAME_HEIGHT)
    {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public static void setMiss(boolean miss)
    {
        Score.miss = miss;
    }
    public static void setHit(boolean hit)
    {
        Score.hit = hit;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString("Score "+String.valueOf(player), 5,15);
        g.setColor(Color.red);
        // g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString("left/right for velocity", 5,30);
        g.setColor(Color.blue);
        // g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString("up/down for angle", 5,45);
        g.setColor(Color.green);
        // g.setFont(new Font("Consolas",Font.PLAIN,20));
        g.drawString("L to launch the ball",5,60);
        g.setColor(Color.red);
        g.setFont(new Font("Consolas",Font.PLAIN,40));
        if (miss)
            g.drawString("Missed.\n L to launch.",GAME_WIDTH/2,GAME_HEIGHT/2);
        if (hit)
            g.drawString("HIT!\n L to launch.",GAME_WIDTH/2,GAME_HEIGHT/2);
    }
}

