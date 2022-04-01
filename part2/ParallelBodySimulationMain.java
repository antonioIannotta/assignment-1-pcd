import java.io.*;

public class ParallelBodySimulationMain {

    public static void main(String[] args) {

        //PERFORMANCE NUMERO CORPI = 100 --- NUMERO ITERAZIONI = 1000
        /*
        SimulationController controller = new SimulationController(100);
        SimulationView viewer = new SimulationView(controller, 600,600);

        long start = System.currentTimeMillis();
        controller.execute(1000, viewer);
        long stop = System.currentTimeMillis() - start;

        try {
            File simulationPerformanceTxt = new File("C:\\Users\\Antonio\\Desktop\\simulation_performance.txt");
            if (simulationPerformanceTxt.createNewFile()) {
                System.out.println("File creato: " + simulationPerformanceTxt.getName());
            } else {
                System.out.println("Il file esiste già.");
            }
        } catch (IOException e) {
            System.out.println("Errore");
            e.printStackTrace();
        }

         try {

             FileWriter fw = new FileWriter("C:\\Users\\Antonio\\Desktop\\simulation_performance.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write("Tempo di esecuzione con 100 corpi e 1000 iterazioni: " + stop + "ms");
             bw.newLine();
             bw.close();

             System.out.println("Tempo di esecuzione con 100 corpi e 1000 iterazioni: " + stop + "ms");
         } catch (Exception e) {
             e.printStackTrace();
         }
            */
        // PERFORMANCE NUMERO CORPI = 100 --- NUMERO ITERAZIONI = 10000

        SimulationController controller = new SimulationController(1000);
        SimulationView viewer = new SimulationView(controller, 600,600);

        long start = System.currentTimeMillis();
        controller.execute(50000, viewer);
        long stop = System.currentTimeMillis() - start;
        try {
            File simulationPerformanceTxt = new File("C:\\Users\\Antonio\\Desktop\\simulation_performance.txt");
            if (simulationPerformanceTxt.createNewFile()) {
                System.out.println("File creato: " + simulationPerformanceTxt.getName());
            } else {
                System.out.println("Il file esiste già.");
            }
        } catch (IOException e) {
            System.out.println("Errore");
            e.printStackTrace();
        }

         try {

             FileWriter fw = new FileWriter("C:\\Users\\Antonio\\Desktop\\simulation_performance.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write("Tempo di esecuzione con 1000 corpi e 50000 iterazioni: " + stop + "ms");
             bw.newLine();
             bw.close();

             System.out.println("Tempo di esecuzione con 1000 corpi e 50000 iterazioni: " + stop + "ms");
         } catch (Exception e) {
             e.printStackTrace();
         }

        //PERFORMANCE NUMERO CORPI = 100 --- NUMERO ITERAZIONI = 50000
        /*
            SimulationController controller = new SimulationController(100);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(50000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 100 corpi e 50000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 1000 --- NUMERO ITERAZIONI = 1000
        /*
            SimulationController controller = new SimulationController(1000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 1000 corpi e 1000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 1000 --- NUMERO ITERAZIONI = 10000
        /*
            SimulationController controller = new SimulationController(1000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(10000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 1000 corpi e 10000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 1000 --- NUMERO ITERAZIONI = 50000
        /*
            SimulationController controller = new SimulationController(100);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 100 corpi e 1000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 5000 --- NUMERO ITERAZIONI = 1000
        /*
            SimulationController controller = new SimulationController(5000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 5000 corpi e 1000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 5000 --- NUMERO ITERAZIONI = 10000
        /*
            SimulationController controller = new SimulationController(5000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(10000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 5000 corpi e 10000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 5000 --- NUMERO ITERAZIONI = 50000
        /*
            SimulationController controller = new SimulationController(5000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(50000, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 5000 corpi e 50000 iterazioni: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 100
        /*
            SimulationController controller = new SimulationController(100);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 100 corpi: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 1000
        /*
            SimulationController controller = new SimulationController(1000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 1000 corpi: " + stop );
         */

        //PERFORMANCE NUMERO CORPI = 5000
        /*
            SimulationController controller = new SimulationController(5000);
            SimulationView viewer = new SimulationView(controller, 600,600);

            long start = System.currentTimeMillis();
            controller.execute(1, viewer);
            long stop = System.currentTimeMillis() - start;
            System.out.println("Tempo di esecuzione con 5000 corpi: " + stop );
         */

    }
}
