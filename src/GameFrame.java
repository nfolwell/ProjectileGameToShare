/** An attempt to make a projectile-style game -  sorta like the old "artillery simulator" from the 70s
 * can be converted to an "angry birds-like" game
 */
import java.awt.*;
import java.awt.event.*;
/** This is the uper level of "set-up" for the game
 *  GameFrame has a GamePanel which is where much of the
 *  game logic happens.  All the commands below set up
 *  the windoow containing the game.
 *
 */
import javax.swing.*;
import java.util.*;

public class GameFrame extends JFrame
{
    GamePanel panel;
    public  GameFrame()
    {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Projectile Shooter");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
