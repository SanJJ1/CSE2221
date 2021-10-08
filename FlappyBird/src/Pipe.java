import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;

public class Pipe
{
    public static String s = "assets/sprites/";
    public static ImageIcon pipeDown = new ImageIcon(s + "pipe-green-down.png");
    public static ImageIcon pipeUp = new ImageIcon(s + "pipe-green.png");
    public static double pipeX = 0, pipeVel = RunGraphics.bVel;
    public static int pipeY = ThreadLocalRandom.current().nextInt(-210, 31),
     gap = 60, pipeWidth = 52, pipeHeight = 300,
    // Max pipeY = 30, min = -210
     xGap = Main.screenWidth + pipeWidth;

    public Pipe()
    {

    }

    public static void draw(Component c, Graphics g)
    {
        pipeDown.paintIcon(c, g, (int)pipeX + xGap - pipeWidth, pipeY - gap);
        pipeUp.paintIcon(c, g, (int)pipeX + xGap - pipeWidth, pipeHeight + pipeY + gap);
        pipeX -= pipeVel;
        if (pipeX != pipeX % xGap)
        {
            pipeY = ThreadLocalRandom.current().nextInt(-210, 31);
        }

        pipeX %= xGap;

    }
}




