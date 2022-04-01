import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelBodySimulationMain {

    public static void main(String[] args) {

        int nBodies = 5000;

        ExecutorService executorService = Executors.newFixedThreadPool(nBodies+ 4);

        SimulationController controller = new SimulationController(nBodies, executorService);
        SimulationView viewer = new SimulationView(controller, 600,600);

        executorService.execute(()-> {
            long start = System.currentTimeMillis();
            controller.execute(1000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con tot corpi: " + stop + " millisecondi");
        });

    }
}
