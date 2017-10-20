package model;

public class MMS implements kendal{

    private float lambda;
    private float mu;
    private float ro;
    private int s; //Number of servers

    /** Constructor **/
    public MMS(float lambda, float mu, int s) {
        this.lambda = lambda;
        this.mu = mu;
        this.s = s;
        this.ro = (lambda/s*mu);
    }

    /** Getter **/
    private float getLambda() {return lambda;}
    private float getMu() {return mu;}
    private float getRo() {return ro;}


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
    public static int factorielleRecursive(int n) {
        if (n>1)
            return n*factorielleRecursive(n-1);
        else
            return 1;
    }

    @Override
    public void MAJRo(){
        ro = (this.getLambda()/(s*this.getMu()));
    }

    @Override
    public double getQ0(){
        double denominator=0;
        for(int i=0; i<s;i++){
            denominator += (Math.pow(ro*s,s)/i)+(Math.pow(ro*s,s)/(factorielleRecursive(s)*(1-ro)));
        }
        return 1/denominator;
    }

    @Override
    public double getQi(int i){
        if(i<1){
            return (Math.pow(s*ro,i)/factorielleRecursive(i))*getQ0();
        }else{
            return (Math.pow(s,s)*Math.pow(ro,i))/factorielleRecursive(s);
        }
    }

    @Override
    public double getLq(){
        return getQ0()*(Math.pow(ro*s,ro)*ro)/(factorielleRecursive(s)*(Math.pow(1-ro,2)));
    }

    @Override
    public double getWq(){
        return getLq()/lambda;
    }

    @Override
    public double getW(){
        return getWq()/(1/lambda);
    }

    @Override
    public double getL(){
        return lambda/getW();
    }
}