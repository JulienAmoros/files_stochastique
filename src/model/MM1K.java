package model;

public class MM1K implements kendal{

    private float lambda;
    private float mu;
    private float ro;
    private int k;

    /** Constructor **/
    public MM1K(float lambda, float mu, int k) {
        this.lambda = lambda;
        this.mu = mu;
        this.ro = (lambda/mu);
        this.k = k;
    }

    /** Getter **/
    public float getLambda() {return lambda;}
    public float getMu() {return mu;}
    private float getRo() {return ro;}
    private float getK() {return k;}

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

    public void setK(int k){
        this.k = k;
    }

    /** Function **/
    @Override
    public void MAJRo(){ro = (this.getLambda()/this.getMu());}

    @Override
    public double getQ0(){return 0;}

    @Override
    public double getQi(int i){
        if(getRo()==1){
            return (1/(getK()+1));
        }else{
            return ( (1-ro)*Math.pow(ro,i)/(1-(Math.pow(ro,k+1))) );
        }
    }

    @Override
    public double getL(){
        if(ro==1){
            return k/2;
        }else{
            double numerator = ro*(1-(k+1)*Math.pow(ro,k)+k*Math.pow(ro,k+1));
            double denominator = (1-ro)*(1-Math.pow(ro,k+1));
            return numerator / denominator;
        }
    }
    @Override
    public double getLq(){
        return getL()-(1-getQi(0));
    }

    @Override
    public double getW() {
        return 0;
    } //TODO

    @Override
    public double getWq() {
        return 0;
    } //TODO

    @Override
    public double getTau(float t){return 0;} //TODO
}