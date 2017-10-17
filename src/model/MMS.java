package model;

public class MMS{

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



    private void MAJRo(){
        ro = (this.getLambda()/(s*this.getMu()));
    }
    private double getQ0(){
        double denominator=0;
        for(int i=0; i<s;i++){
            denominator += (Math.pow(ro*s,s)/i)+(Math.pow(ro*s,s)/(factorielleRecursive(s)*(1-ro)));
        }
        return 1/denominator;
    }

    private double getQi(int i){
        if(i<1){
            return (Math.pow(s*ro,i)/factorielleRecursive(i))*getQ0();
        }else{
            return (Math.pow(s,s)*Math.pow(ro,i))/factorielleRecursive(s);
        }
    }

    private double getLq(){
        return getQ0()*(Math.pow(ro*s,ro)*ro)/(factorielleRecursive(s)*(Math.pow(1-ro,2)));
    }

    private double getWq(){
        return getLq()/lambda;
    }
    private double getW(){
        return getWq()/(1/lambda);
    }

    private double getL(){
        return lambda/getW();
    }



}