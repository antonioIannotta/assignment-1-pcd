import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    private Boundary boundary;
    private List<BodyThread> bodyThreads;

    private int countForce = 0;
    private int countBoundary = 0;
    private static final double REPULSIVE_CONST = 0.01;

    private final Lock lock = new ReentrantLock();
    private final Condition conditionForce = lock.newCondition();
    private final Condition conditionBoundary = lock.newCondition();

    public Monitor(Boundary boundary, List<BodyThread> bodyThreads) {
        this.boundary = boundary;
        this.bodyThreads = bodyThreads;
    }

    public V2d computeTotalForceOnBody(BodyThread bt) {
        V2d totalForce = new V2d(0, 0);
        try {
            while (countForce == 0) {
                conditionForce.await();
            }

            countForce+=1;
            for (int i = 0; i < this.bodyThreads.size(); i++) {
                BodyThread other = bodyThreads.get(i);
                if (!bt.equals(other)) {
                    try {
                        V2d forceByOtherBody = this.computeRepulsiveForce(bt, other);
                        totalForce.sum(forceByOtherBody);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        totalForce.sum(bt.getBody().getCurrentFrictionForce());
        countForce--;
        conditionForce.signalAll();
        return totalForce;
    }

    public void checkAndSolveBoundaryCollision(BodyThread bt) {
        try {
            while (countBoundary == 1) {
                conditionBoundary.await();
            }
            countBoundary+=1;
            double x = bt.getBody().getPos().getX();
            double y = bt.getBody().getPos().getY();
            if (x > this.boundary.getX_1()) {
                bt.getBody().getPos().change(this.boundary.getX_1(), bt.getBody().getPos().getY());
                bt.getBody().getVel().change(-bt.getBody().getVel().getX(), bt.getBody().getVel().getY());
            } else if (x < this.boundary.getX_0()) {
                bt.getBody().getPos().change(this.boundary.getX_0(), bt.getBody().getPos().getY());
                bt.getBody().getVel().change(-bt.getBody().getVel().getX(), bt.getBody().getVel().getY());
            } else if (y > this.boundary.getY_1()) {
                bt.getBody().getPos().change(bt.getBody().getPos().getX(), this.boundary.getY_1());
                bt.getBody().getVel().change(bt.getBody().getVel().getX(), -bt.getBody().getVel().getY());
            } else if (y < this.boundary.getY_0()) {
                bt.getBody().getPos().change(bt.getBody().getPos().getX(), this.boundary.getY_0());
                bt.getBody().getVel().change(bt.getBody().getVel().getX(), -bt.getBody().getVel().getY());
            }
            countBoundary--;
            conditionBoundary.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private V2d computeRepulsiveForce(BodyThread bt1, BodyThread bt2) throws InfiniteForceException {
        double distance = bt1.getBody().getDistanceFrom(bt2.getBody());
        if (distance > 0) {
            try {
                return new V2d(bt2.getBody().getPos(), bt1.getBody().getPos())
                        .normalize()
                        .scalarMul(bt2.getBody().getMass() * REPULSIVE_CONST / (distance * distance));
            } catch (Exception e) {
                throw new InfiniteForceException();
            }
        } else {
            throw new InfiniteForceException();
        }
    }

}
