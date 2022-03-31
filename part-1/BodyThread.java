public class BodyThread extends Thread {

    private Monitor monitor;
    private Body body;
    private Barrier barrier;

    public BodyThread(Monitor monitor, Body body, Barrier barrier) {
        this.monitor = monitor;
        this.body = body;
        this.barrier = barrier;
    }

    public void run() {
            // 1.0 è un valore provvisorio
            this.body.updateVelocity(new V2d(monitor.computeTotalForceOnBody(this.body).scalarMul(1/ body.getMass())), 0.001);

            //System.out.println(this.body.getVel().getX() + " " + this.body.getVel().getY());

            this.body.updatePos(0.001);

            monitor.checkAndSolveBoundaryCollision(this.body);
        try {
            barrier.hitAndWaitAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Body getBody() {
        return this.body;
    }
}