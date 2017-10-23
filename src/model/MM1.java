package model;

public class MM1 implements kendal{

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
    @Override
    public float getLambda() {return lambda;}
    @Override
    public float getMu() {return mu;}
    public float getRo() {return ro;}


    /** Setter **/
    @Override
    public void setLambda(float lambda) {
        this.lambda = lambda;
        MAJRo();
    }
    @Override
    public void setMu(float mu) {
        this.mu = mu;
        MAJRo();
    }

    /** Function **/
    @Override
    public void MAJRo(){
        ro = (this.getLambda()/this.getMu());
    }

    @Override
    public double getQ0() {
        return 1-ro;
    }
    @Override
    public double getL(){
        return (this.getLambda()/(this.getMu()-this.getLambda()));
    }
    @Override
    public double getLq(){
        return (
                (this.getLambda()*this.getLambda())/(this.getMu()*(this.getMu()-this.getLambda())));
    }
    @Override
    public double getW(){
        return (1/(this.getMu()-this.getLambda()));
    }
    @Override
    public double getWq(){
        return (this.getLambda()/(this.getMu()/(this.getMu()-this.getLambda())));
    }
    @Override
    public double getQi(int i){return Math.pow(ro,i)*(1-ro);}
    @Override
    public double getTau(float t){
        return Math.exp((-getMu())*(1-getRo())*t);
    }

}