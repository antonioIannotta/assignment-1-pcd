import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    private Boundary boundary;
    private List<Body> bodyList;

    private int countForce = 0;
    private int countBoundary = 0;
    private static final double REPULSIVE_CONST = 0.01;

    //private final Lock lock = new ReentrantLock();
    //private final Condition conditionForce = lock.newCondition();
    //private final Condition conditionBoundary = lock.newCondition();

    public Monitor(Boundary boundary, List<Body> bodyList) {
        this.boundary = boundary;
        this.bodyList = bodyList;
    }

    public synchronized V2d computeTotalForceOnBody(Body b) {
        V2d totalForce = new V2d(0, 0);
            while (countForce == 1) {
                try{
                    wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            countForce=1;
            System.out.println("Start force");

            for (int i = 0; i < this.bodyList.size(); i++) {
                Body other = bodyList.get(i);
                if (!b.equals(other)) {
                    try {
                        V2d forceByOtherBody = this.computeRepulsiveForce(b, other);
                        totalForce.sum(forceByOtherBody);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            totalForce.sum(b.getCurrentFrictionForce());

            countForce=0;
            System.out.println("Finish force");
            notify();
            //conditionForce.signalAll();

        /*totalForce.sum(b.getCurrentFrictionForce());
        countForce--;
        conditionForce.signalAll();
        System.out.println("Finish force");*/
        return totalForce;
    }

    public synchronized void checkAndSolveBoundaryCollision(Body b) {

            while (countBoundary == 1) {
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Start boundary");
            countBoundary+=1;
            double x = b.getPos().getX();
            double y = b.getPos().getY();
            if (x > this.boundary.getX_1()) {
                b.getPos().change(this.boundary.getX_1(), b.getPos().getY());
                b.getVel().change(-b.getVel().getX(), b.getVel().getY());
            } else if (x < this.boundary.getX_0()) {
                b.getPos().change(this.boundary.getX_0(), b.getPos().getY());
                b.getVel().change(-b.getVel().getX(), b.getVel().getY());
            } else if (y > this.boundary.getY_1()) {
                b.getPos().change(b.getPos().getX(), this.boundary.getY_1());
                b.getVel().change(b.getVel().getX(), -b.getVel().getY());
            } else if (y < this.boundary.getY_0()) {
                b.getPos().change(b.getPos().getX(), this.boundary.getY_0());
                b.getVel().change(b.getVel().getX(), -b.getVel().getY());
            }
            countBoundary--;
            System.out.println("Finish Boundary");
            notify();

            //conditionBoundary.signalAll();

    }

    private V2d computeRepulsiveForce(Body b1, Body b2) throws InfiniteForceException {
        double distance = b1.getDistanceFrom(b2);
        if (distance > 0) {
            try {
                return new V2d(b2.getPos(), b1.getPos())
                        .normalize()
                        .scalarMul(b2.getMass() * REPULSIVE_CONST / (distance * distance));
            } catch (Exception e) {
                throw new InfiniteForceException();
            }
        } else {
            throw new InfiniteForceException();
        }
    }

}
