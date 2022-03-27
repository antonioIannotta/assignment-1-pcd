import java.util.Random;

public class BodyThread extends Thread {

    private Monitor monitor;
    private Body body;

    public BodyThread(Monitor monitor, Body body) {
        this.monitor = monitor;
        this.body = body;
    }

    public void run() {

        Random rand = new Random();
        int n = rand.nextInt(2);

        if (n == 0) {
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 1.0);
            // 1.0 è un valore provvisorio
            monitor.checkAndSolveBoundaryCollision(this.body);
        } else {
            monitor.checkAndSolveBoundaryCollision(this.body);
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 1.0);
        }

    }

    public Body getBody() {
        return this.body;
    }

}