public class Boundary {
    private double x_0;
    private double y_0;
    private double x_1;
    private double y_1;

    public Boundary(double x_0, double y_0, double x_1, double y_1){
        this.x_0 = x_0;
        this.y_0 = y_0;
        this.y_1 = y_1;
        this.x_1= x_1;
    }

    public double getX_1(){
        return this.x_1;
    }

    public double getX_0(){
        return this.x_0;
    }

    public double getY_0(){
        return this.y_0;
    }

    public double getY_1(){
        return this.y_1;
    }
}
