public class MM1{

    private float lambda;
    private float mu;
    private float ro;

    /** Constructor **/
    public MM1(float lambda, float mu) {
        this.lambda = lambda;
        this.mu = mu;
        this.ro = (lambda/mu);
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
    private MAJRo(){this.getRo() = (this.getLambda()/this.getMu());}
    private getL(){return (this.getLambda()/(this.getMu()-this.getLambda()));}
    private getLq(){return ((this.getLambda()*this.getLambda())/(this.getMu()-this.getLambda()));}
    private.getW(){return (1/(this.getMu()-this.getLambda()));}
    private.getWq(){return (this.getLambda()/(this.getMu()(this.getMu()-this.getLambda()));}
}