import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Barrier {

    private ReentrantLock mutex;
    private Condition c;

    private int nParticipants;
    private int nHits;

    public Barrier(int nParticipants){
        this.nHits = 0;
        this.nParticipants = nParticipants+1;
        mutex = new ReentrantLock();
        c = mutex.newCondition();
    }

    public void hitAndWaitAll() throws InterruptedException {
        try {
            mutex.lock();
            try {
                this.nHits++;
                //System.out.println("Barrier has been hit, waiting for wall to go down.");
                if(nHits == nParticipants)
                    c.signalAll();
                else
                    c.await();
                //System.out.println("Worker passed barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finally {
            mutex.unlock();
        }
    }
}
