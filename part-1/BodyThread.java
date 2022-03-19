public class BodyThread extends Thread {

    private Monitor monitor;
    private Body body;

    public BodyThread(Monitor monitor, Body body) {
        this.monitor = monitor;
        this.body = body;
    }

    public void run() {
        this.body.updateVelocity(monitor.computeTotalForceOnBody(this), 1.0);
        // 1.0 è un valore provvisorio
        monitor.checkAndSolveBoundaryCollision(this);
    }

    public Body getBody() {
        return this.body;
    }
}