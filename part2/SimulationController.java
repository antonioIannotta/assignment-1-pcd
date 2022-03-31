import java.util.ArrayList;
import java.util.Random;

public class SimulationController {


    ArrayList<Body> bodies;
    private Boundary bounds;
    ArrayList<BodyThread> bodyThreads = new ArrayList<>();

    /* virtual time */
    private double vt;

    /* virtual time step */
    double dt;
    private int nBodies;

    public SimulationController(int nBodies) {
        this.nBodies = nBodies;
        testBodySet_multiple_bodies(nBodies);
    }

    public void execute(long nSteps, SimulationView viewer){
        vt = 0;
        dt = 0.001;
        long iter = 0;

            try {
                Monitor monitor = new Monitor(bounds, bodies);
                        while (iter < nSteps) {
                            Barrier barrier = new Barrier(nBodies);
                            try {
                                for (Body b : bodies) {
                                    BodyThread bt = new BodyThread(monitor,b,barrier);
                                    bodyThreads.add(bt);
                                }
                                for (BodyThread bt: bodyThreads) bt.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            try {
                                barrier.hitAndWaitAll();
                                bodyThreads = new ArrayList<>();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            vt = vt + dt;
                            iter++;
                            viewer.display(bodies, vt, iter, bounds);
                        }
            } catch (Exception ignored) {}
        }

    private void testBodySet_multiple_bodies(int nBodies) {
        bounds = new Boundary(-4.0, -4.0, 4.0, 4.0);
        Random rand = new Random(System.currentTimeMillis());
        Random randMass = new Random();
        bodies = new ArrayList<>();
        for (int i = 0; i < nBodies; i++) {
            double x = bounds.getX0()*0.25 + rand.nextDouble() * (bounds.getX1() - bounds.getX0()) * 0.25;
            double y = bounds.getY0()*0.25 + rand.nextDouble() * (bounds.getY1() - bounds.getY0()) * 0.25;
            Body b = new Body(i, new P2d(x, y), new V2d(0, 0), randMass.nextDouble()*10);
            bodies.add(b);
        }
    }
}
