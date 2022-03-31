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
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 0.01);
            this.body.updatePos(1);
            // 1.0 è un valore provvisorio
            /*try{
                sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }*/
            monitor.checkAndSolveBoundaryCollision(this.body);
            this.body.updatePos(1);
        } else {
            monitor.checkAndSolveBoundaryCollision(this.body);
            this.body.updatePos(1);
            /*try{
                sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }*/
            this.body.updateVelocity(monitor.computeTotalForceOnBody(this.body), 0.01);
            this.body.updatePos(1);

        }

    }

    public Body getBody() {
        return this.body;
    }

}
