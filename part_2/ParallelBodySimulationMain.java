import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelBodySimulationMain {

    public static void main(String[] args) {

        int nBodies = 1000;

        ExecutorService exec1 = Executors.newFixedThreadPool(nBodies+ 4);

        SimulationController controller1 = new SimulationController(nBodies, exec1);
        SimulationView viewer1 = new SimulationView(controller1, 600,600);

        exec1.execute(()-> {
            long start = System.currentTimeMillis();
            controller1.execute(1000, viewer1);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con tot corpi: " + stop + " millisecondi");
        });

        ExecutorService exec2 = Executors.newFixedThreadPool(nBodies+ 4);

        SimulationController controller2 = new SimulationController(nBodies, exec2);
        SimulationView viewer2 = new SimulationView(controller2, 600,600);

        exec2.execute(()-> {
            long start = System.currentTimeMillis();
            controller2.execute(2000, viewer2);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con tot corpi: " + stop + " millisecondi");
        });


        ExecutorService exec3 = Executors.newFixedThreadPool(nBodies+ 4);

        SimulationController controller3 = new SimulationController(nBodies, exec3);
        SimulationView viewer3 = new SimulationView(controller3, 600,600);

        exec3.execute(()-> {
            long start = System.currentTimeMillis();
            controller3.execute(5000, viewer3);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con tot corpi: " + stop + " millisecondi");
        });


    }
}
