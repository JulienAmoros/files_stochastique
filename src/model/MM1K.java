package model;

public class MM1K{

    private float lambda;
    private float mu;
    private float ro;
    private float k;

    /** Constructor **/
    public MM1K(float lambda, float mu, float k) {
        this.lambda = lambda;
        this.mu = mu;
        this.ro = (lambda/mu);
        this.k = this.k;
    }

    /** Getter **/
    private float getLambda() {return lambda;}
    private float getMu() {return mu;}
    private float getRo() {return ro;}
    private float getK() {return k;}


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

    private double getQi(float i){
        if(getRo()==1){
            return (1/(getK()+1));
        }else{
            return ( (1-ro)*Math.pow(ro,i)/(1-(Math.pow(ro,k+1))) );
        }
    }
    private double getL(){
        if(ro==1){
            return k/2;
        }else{
            double numerator = ro*(1-(k+1)*Math.pow(ro,k)+k*Math.pow(ro,k+1));
            double denominator = (1-ro)*(1-Math.pow(ro,k+1));
            return numerator / denominator;
        }
    }
    private double getLq(){
        return getL()-(1-getQi(0));
    }
}