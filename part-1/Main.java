import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Body> list = null;
        List<BodyThread> btList = new ArrayList<>();
        Boundary boundary = new Boundary(-5,-5,5,5);


        //*******TEST PERFORMANCE 100 CORPI
        list = fillList(100);
        Monitor monitor100 = new Monitor(boundary,list);

        for(int i=0; i<100; i++){
            btList.add(new BodyThread(monitor100, list.get(i)));
        }

        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            btList.get(i).start();
            System.out.println("a");
        }
        long stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 100 corpi: " + stop + " millisecondi");


        //*******TEST PERFORMANCE 1000 CORPI
        btList.clear();
        list = fillList(1000);
        Monitor monitor1000 = new Monitor(boundary,list);
        for(int i=0; i<1000; i++){
            btList.add(new BodyThread(monitor100, list.get(i)));
        }

        start = System.currentTimeMillis();
        for(int i=0; i<1000; i++){
            btList.get(i).start();
            System.out.println("b");
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 1000 corpi: " + stop + " millisecondi");


        //*******TEST PERFORMANCE 5000 CORPI
        btList.clear();
        list = fillList(5000);
        Monitor monitor5000 = new Monitor(boundary,list);
        for(int i=0; i<5000; i++){
            btList.add(new BodyThread(monitor100, list.get(i)));
        }

        start = System.currentTimeMillis();
        for(int i=0; i<5000; i++){
            btList.get(i).start();
            System.out.println("c");
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 5000 corpi: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 100 CORPI E 1000 iterazioni

        btList.clear();
        list = fillList(100);
        monitor100 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<1000; j++) {
            btList.clear();
            for (int i = 0; i < 100; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 100; i++) {
                btList.get(i).start();
                System.out.println("d");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 100 corpi e 1000 iterazioni: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 100 CORPI E 10000 iterazioni

        btList.clear();
        list = fillList(100);
        monitor100 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<10000; j++) {
            btList.clear();
            for (int i = 0; i < 100; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 100; i++) {
                btList.get(i).start();
                System.out.println("e");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 100 corpi e 10000 iterazioni: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 100 CORPI E 50000 iterazioni

        btList.clear();
        list = fillList(100);
        monitor100 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<5000; j++) {
            btList.clear();
            for (int i = 0; i < 100; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 100; i++) {
                btList.get(i).start();
                System.out.println("f");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 100 corpi e 5000 iterazioni: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 1000 CORPI E 1000 iterazioni

        btList.clear();
        list = fillList(1000);
        monitor1000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<1000; j++) {
            btList.clear();
            for (int i = 0; i < 1000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 1000; i++) {
                btList.get(i).start();
                System.out.println("g");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 1000 corpi e 1000 iterazioni: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 1000 CORPI E 10000 iterazioni

        btList.clear();
        list = fillList(1000);
        monitor1000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<10000; j++) {
            btList.clear();
            for (int i = 0; i < 1000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 1000; i++) {
                btList.get(i).start();
                System.out.println("h");
            }
        }

        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 1000 corpi e 5000 iterazioni: " + stop + " millisecondi");


        //*******TEST PERFORMANCE 1000 CORPI E 1000 iterazioni

        btList.clear();
        list = fillList(1000);
        monitor1000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<5000; j++) {
            btList.clear();
            for (int i = 0; i < 1000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 1000; i++) {
                btList.get(i).start();
                System.out.println("i");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 1000 corpi e 5000 iterazioni: " + stop + " millisecondi");

        //*******TEST PERFORMANCE 5000 CORPI E 1000 iterazioni

        btList.clear();
        list = fillList(5000);
        monitor5000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<1000; j++) {
            btList.clear();
            for (int i = 0; i < 5000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 5000; i++) {
                btList.get(i).start();
                System.out.println("j");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 5000 corpi e 1000 iterazioni: " + stop + " millisecondi");


        //*******TEST PERFORMANCE 5000 CORPI E 5000 iterazioni

        btList.clear();
        list = fillList(5000);
        monitor5000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<5000; j++) {
            btList.clear();
            for (int i = 0; i < 5000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 5000; i++) {
                btList.get(i).start();
                System.out.println("k");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 5000 corpi e 5000 iterazioni: " + stop + " millisecondi");


        //*******TEST PERFORMANCE 5000 CORPI E 10000 iterazioni

        btList.clear();
        list = fillList(1000);
        monitor5000 = new Monitor(boundary,list);


        start = System.currentTimeMillis();
        for(int j=0; j<10000; j++) {
            btList.clear();
            for (int i = 0; i < 5000; i++) {
                btList.add(new BodyThread(monitor100, list.get(i)));
            }
            for (int i = 0; i < 5000; i++) {
                btList.get(i).start();
                System.out.println("l");
            }
        }
        stop = System.currentTimeMillis() - start;
        System.out.println("Tempo di esecuzione con 5000 corpi e 10000 iterazioni: " + stop + " millisecondi");

    }

    private static List<Body> fillList(int number){
        List<Body> bodies = new ArrayList<>();
        for (int i=1,k=1;i<=number;i++,k+=2) {
            Body body = new Body(i, new P2d(k, k+1), new V2d(k, k+1), k*2);
            bodies.add(body);
        }
        return bodies;
    }
}
