import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RunGraphics extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    Timer t = new Timer(7, this);
    double x = 70, y = 100, yVel = 0, xVel = 0, grav = .13, birdWidth = 34,
            birdHeight = 25, bgX = 0, bgVel = .3;

    public static double bX = 0, bVel = 1.3;
    String s = "assets/sprites/";
    int i = ThreadLocalRandom.current().nextInt(0, 3), j = 0;
    boolean pause = false;

    ImageIcon[] backgrounds = { new ImageIcon(this.s + "background-day.png"),
            new ImageIcon(this.s + "background-night.png") };
    ImageIcon[][] birdFrames = {
            { new ImageIcon(this.s + "yellowbird-downflap.png"),
                    new ImageIcon(this.s + "yellowbird-midflap.png"),
                    new ImageIcon(this.s + "yellowbird-upflap.png") },
            { new ImageIcon(this.s + "redbird-downflap.png"),
                    new ImageIcon(this.s + "redbird-midflap.png"),
                    new ImageIcon(this.s + "redbird-upflap.png") },
            { new ImageIcon(this.s + "bluebird-downflap.png"),
                    new ImageIcon(this.s + "bluebird-midflap.png"),
                    new ImageIcon(this.s + "bluebird-upflap.png") } };

    ImageIcon background = this.backgrounds[ThreadLocalRandom.current()
            .nextInt(0, 2)];
    ImageIcon base = new ImageIcon(this.s + "base.png");

    private ImageIcon bird;

    public RunGraphics() {
        this.t.start();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        this.background.paintIcon(this, g, (int) this.bgX, 0);
        this.background.paintIcon(this, g, (int) this.bgX + 280, 0);
        this.background.paintIcon(this, g, (int) this.bgX + 560, 0);
        this.bgX -= this.bgVel;
        this.bgX %= 280;

        Pipe.draw(this, g);

        this.base.paintIcon(this, g, (int) bX, 420);
        this.base.paintIcon(this, g, (int) bX + 336, 420);
        this.base.paintIcon(this, g, (int) bX + 336 + 336, 420);
        bX -= bVel;
        bX %= 336;
        Rectangle2D baseHitBox = new Rectangle2D.Double(0, 420,
                Main.screenWidth, 112);

        this.j++;
        this.j %= 3;
        this.bird = this.birdFrames[this.i][this.j];
        this.bird.paintIcon(this, g, (int) this.x, (int) this.y);
        Ellipse2D birdHitBox = new Ellipse2D.Double((int) this.x, (int) this.y,
                this.birdWidth, this.birdHeight);

        this.detectEdges(birdHitBox, baseHitBox);

        this.t.start();
    }

    public void detectEdges(Ellipse2D birdhit, Rectangle2D basehit) {

        if (this.y < 3) {
            this.y = 3;
        } else if (birdhit.intersects(basehit)) {
            this.bounce();
        }

    }

    public void bounce() {
        this.yVel = -5;
    }

    private static double sigmoid(double x) {
        int n = 20;
        double nd2 = 10;
        double nd = .05;
        return n / (1 + Math.exp(-4 * x * nd)) - nd2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.pause) {
            this.x += this.xVel;
            this.y += this.yVel;
            this.yVel += this.grav;
            this.yVel = sigmoid(this.yVel);
            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            this.bounce();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_P) {
            this.pause = !this.pause;
        }
    }
}
