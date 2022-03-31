public class Body {

    private P2d pos;
    private V2d vel;
    private double mass;
    private int id;

    private static final double FRICTION_CONST = 0.1;

    public Body(int id, P2d pos, V2d vel, double mass) {
        this.id = id;
        this.pos = pos;
        this.vel = vel;
        this.mass = mass;
    }

    public double getMass() {
        return this.mass;
    }

    public int getId() {
        return this.id;
    }

    public V2d getVel() {
        return this.vel;
    }

    public P2d getPos() {
        return this.pos;
    }

    public void updatePos(double dt){
        //System.out.println("Old pos:" + this.pos.getX() + ", " + this.pos.getY());
        pos.sum(new V2d(vel).scalarMul(dt));
        //System.out.println("New pos:" + this.pos.getX() + ", " + this.pos.getY());
    }

    public void updateVelocity(V2d acc, double dt) {
        this.vel = vel.sum(new V2d(acc).scalarMul(dt));
    }

    public V2d getCurrentFrictionForce() {
        return new V2d(this.getVel()).scalarMul(-FRICTION_CONST);
    }

    public double getDistanceFrom(Body b2) {
        double dx = this.pos.getX() - b2.getPos().getX();
        double dy = this.pos.getY() - b2.getPos().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
