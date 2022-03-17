public class V2d {
    
    public double x,y;

    public V2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public V2d(V2d v){
        this.x = v.getX();
        this.y = v.getY();
    }

    public V2d(P2d from, P2d to){
        this.x = to.getX() - from.getX();
        this.y = to.getY() - from.getY();
    }

    public V2d scalarMul(double k){
        this.x *= k;
        this.y *= k;
        return this;
    }

    public V2d sum(V2d v){
        this.x += v.getX();
        this.y += v.getY();
        return this;
    }

    public V2d normalize() throws NullVectorException{
        double mod = Math.sqrt((this.getX() * this.getX()) + (this.getY() * this.getY()));
        if(mod > 0){
            this.x /= mod;
            this.y /= mod;
            return this;
        }else{
            throw new NullVectorException();
        }
    }

    public V2d change(double x, double y){
        this.x = x;
        this.y = y;
        return this;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}