import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class second extends JPanel implements ActionListener {
    Timer t = new Timer(5, this);
    double x = 0, y = 0, velX = 2, velY = 2;

    public void painComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(this.x, this.y, 40, 40);
        g2.fill(circle);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x += this.velX;
        this.y += this.velY;
        this.repaint();

    }

}
