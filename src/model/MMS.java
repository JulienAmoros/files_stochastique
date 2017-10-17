package model;

public class MMS{

    private float lambda;
    private float mu;
    private float ro;
    private float s; //Number of servers

    /** Constructor **/
    public MMS(float lambda, float mu, float s) {
        this.lambda = lambda;
        this.mu = mu;
        this.s = s;
        this.ro = (lambda/s*mu);
    }

    /** Getter **/
    public float getLambda() {return lambda;}
    public float getMu() {return mu;}
    public float getRo() {return ro;}


    /** Setter **/
    public void setLambda(float lambda) {
        this.lambda = lambda;
        MAJRo();
    }
    public void setMu(float mu) {
        this.mu = mu;
        MAJRo();
    }

    /** Function **/
    private void MAJRo(){
        ro = (this.getLambda()/this.getMu());
    }
    private float getL(){return (this.getLambda()/(this.getMu()-this.getLambda()));}
    private float getLq(){return ((this.getLambda()*this.getLambda())/(this.getMu()-this.getLambda()));}
    private float getW(){return (1/(this.getMu()-this.getLambda()));}
    private float getWq(){return (this.getLambda()/(this.getMu()(this.getMu()-this.getLambda()));}
}