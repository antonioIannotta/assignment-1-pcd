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
            while(true){
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 1.0);
            // 1.0 è un valore provvisorio
            try{
                sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
            monitor.checkAndSolveBoundaryCollision(this.body);
            }
        } else {
            while(true){
            monitor.checkAndSolveBoundaryCollision(this.body);
            try{
                sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 1.0);
        }
        }

    }

    public Body getBody() {
        return this.body;
    }

}
