public class ParallelBodySimulationMain {

    public static void main(String[] args) {


        SimulationController controller = new SimulationController(100);
        SimulationView viewer = new SimulationView(controller, 600,600);

        controller.execute(50000, viewer);

    }
}
