import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Body b1 = new Body(1, new P2d(1,2), new V2d(1,2), 10);
        Body b2 = new Body(2, new P2d(3,4), new V2d(3,4), 11);
        Body b3 = new Body(3, new P2d(5,6), new V2d(5,6), 9);
        Body b4 = new Body(4, new P2d(7,8), new V2d(7,8), 12);

        List<Body> list = new ArrayList<Body>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);

        Boundary boundary = new Boundary(5,5,5,5);

        Monitor monitor = new Monitor(boundary,list);

        BodyThread bt1 = new BodyThread(monitor,b1);
        BodyThread bt2 = new BodyThread(monitor,b2);
        BodyThread bt3 = new BodyThread(monitor,b3);
        BodyThread bt4 = new BodyThread(monitor,b4);

        List<BodyThread> btList = new ArrayList<>();
        btList.add(bt1);
        btList.add(bt2);
        btList.add(bt3);
        btList.add(bt4);

        for(int i = 0; i < 4; i++){
            btList.get(i).start();
        }

    }
}
