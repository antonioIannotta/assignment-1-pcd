import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SimulationView extends JFrame implements ActionListener,KeyListener {

    private SimulationController controller;

    private VisualiserPanel panel;

    private JButton button;

    public SimulationView(SimulationController controller, int w, int h) {
        super("My View");
        setSize(w,h);
        setResizable(false);

        Container p = getContentPane();
        p.setFocusable(true);
        p.requestFocusInWindow();
        p.addKeyListener(this);

        this.controller = controller;
        panel = new VisualiserPanel(w,h);

        button = new JButton("Stop");
        button.addActionListener(this);
        button.addKeyListener(this);
        panel.addKeyListener(this);

        p.add(button,BorderLayout.NORTH);
        p.add(panel);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(-1);
            }
            public void windowClosed(WindowEvent ev){
                System.exit(-1);
            }
        });
        this.setVisible(true);
    }

    public void display(ArrayList<Body> bodies, double vt, long iter, Boundary bounds){
        try {
            SwingUtilities.invokeAndWait(() -> {
                panel.display(bodies, vt, iter, bounds);
                repaint();
            });
        } catch (Exception ignored) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.button.setText(controller.isRunning() ? "Start" : "Stop");
            controller.changeRunning();
        } catch (Exception ignored) {}
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38){  		/* KEY UP */
            panel.updateScale(1.1);
        } else if (e.getKeyCode() == 40){  	/* KEY DOWN */
            panel.updateScale(0.9);
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static class VisualiserPanel extends JPanel {

        private ArrayList<Body> bodies;
        private Boundary bounds;

        private long nIter;
        private double vt;
        private double scale = 1;

        private long dx;
        private long dy;

        public VisualiserPanel(int w, int h){
            setSize(w,h);
            dx = w/2 - 20;
            dy = h/2 - 20;
        }

        public void paint(Graphics g){
            if (bodies != null) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.clearRect(0,0,this.getWidth(),this.getHeight());


                int x0 = getXcoord(bounds.getX0());
                int y0 = getYcoord(bounds.getY0());

                int wd = getXcoord(bounds.getX1()) - x0;
                int ht = y0 - getYcoord(bounds.getY1());

                g2.drawRect(x0, y0 - ht, wd, ht);
                DecimalFormat df = new DecimalFormat("#.#");

                bodies.forEach( b -> {
                    P2d p = b.getPos();
                    int radius = (int) (10*scale);
                    if (radius < 1) {
                        radius = 1;
                    }
                    g2.drawOval(getXcoord(p.getX()),getYcoord(p.getY()), radius, radius);
                    g2.drawString(df.format(b.getMass()),getXcoord(p.getX())+(radius/2),getYcoord(p.getY())+(radius/2));
                });
                String time = String.format("%.2f", vt);
                g2.drawString("Bodies: " + bodies.size() + " - vt: " + time + " - nIter: " + nIter + " (UP for zoom in, DOWN for zoom out)", 2, 20);
            }
        }

        private int getXcoord(double x) {
            return (int)(dx + x*dx*scale);
        }

        private int getYcoord(double y) {
            return (int)(dy - y*dy*scale);
        }

        public void display(ArrayList<Body> bodies, double vt, long iter, Boundary bounds){
            this.bodies = bodies;
            this.bounds = bounds;
            this.vt = vt;
            this.nIter = iter;
        }

        public void updateScale(double k) {
            scale *= k;
        }


    }
}
