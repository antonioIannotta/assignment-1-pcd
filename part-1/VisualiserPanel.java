import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;


    public class VisualiserPanel extends JPanel {
        private P2d[] positions;
        private long dx;
        private long dy;

        public VisualiserPanel(int w, int h) {
            setSize(w, h);
            dx = w / 2 - 20;
            dy = h / 2 - 20;
        }


        public class Context {

            private Boundary bounds;
            private ArrayList<BallAgent> balls;

            public Context() {
                bounds = new Boundary(-1.0, -1.0, 1.0, 1.0);
                balls = new ArrayList<BallAgent>();
            }
            // questo è il thread di ricci noi dovremmo adattarlo al nostro oggetto BodyThread
            public class BallAgent extends Thread {

                private P2d pos;
                private V2d vel;
                private boolean stop;
                private double speed;
                private Context ctx;
                private long lastUpdate;

                public BallAgent(Context ctx) {
                    this.ctx = ctx;
                    pos = new P2d(0, 0);
                    Random rand = new Random(System.currentTimeMillis());
                    double dx = rand.nextDouble();
                    vel = new V2d(dx, Math.sqrt(1 - dx * dx));
                    speed = rand.nextDouble() * 3;
                    stop = false;
                }
            }
        }
    }

