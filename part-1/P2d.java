public class P2d {
    
    private double x;
    private double y;
    
    public P2d(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public P2d sum(V2d v){
        this.x += v.x;
        this.y += v.y;
        return this;
    }
    
    public void change(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}