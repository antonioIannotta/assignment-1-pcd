import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelBodySimulationMain {

    public static void main(String[] args) {

        int nBodies = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(nBodies+ 4);

        SimulationController controller = new SimulationController(nBodies, executorService);
        SimulationView viewer = new SimulationView(controller, 600,600);

        executorService.execute(()-> controller.execute(50000, viewer));

    }
}
