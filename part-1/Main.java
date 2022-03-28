import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Body> list = new ArrayList<>();
        List<BodyThread> btList = new ArrayList<>();
        Boundary boundary = new Boundary(5,5,5,5);
        final int NUMBER_BODY = 500;

        // Aggiungo N Body
        for (int i=1,k=1;i<=NUMBER_BODY;i++,k+=2) {
            Body body = new Body(i, new P2d(k, k+1), new V2d(k, k+1), k*2);
            list.add(body);
        }
        Monitor monitor = new Monitor(boundary,list);

        // Aggiungo N BodyThread
        for (int i=0;i<NUMBER_BODY;i++)
            btList.add(new BodyThread(monitor, list.get(i)));

        // Run
        for (int i=0;i<NUMBER_BODY;i++)
            btList.get(i).start();

    }
}
