package model;

public class MMS implements kendal{

    private float lambda;
    private float mu;
    private float ro;
    private int s;

    /** Constructor **/
    public MMS(float lambda, float mu, int s) {
        this.lambda = lambda;
        this.mu = mu;
        this.s = s;
        this.ro = (lambda/(s*mu));
    }

    /** Getter **/
    @Override
    public float getLambda() {return lambda;}
    @Override
    public float getMu() {return mu;}
    @Override
    public float getRo() {return ro;}

    public float getS() {return s;}


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

    public void setS(int s){
        this.s = s;
    }

    /** Function **/
    @Override
    public boolean isValid(){
        return (getLambda()<(getS()*getMu()));
    }
    public static int factorielleRecursive(int n) {
        if (n>1)
            return n*factorielleRecursive(n-1);
        else
            return 1;
    }

    @Override
    public void MAJRo(){
        ro = (this.getLambda()/(getS()*getMu()));
    }

    @Override
    public double getQ0(){
        double denominator=0;
        for(int i=0; i<s;i++){
            denominator += (Math.pow(ro*s,i)/factorielleRecursive(i));
        }
        return 1/(denominator+(Math.pow(ro*s,s)/(factorielleRecursive(s)*(1-ro))));
    }

    @Override
    public double getQi(int i){
        if(i<getS()){
            return (Math.pow(s*ro,i)/factorielleRecursive(i))*getQ0();
        }else{
            return ((Math.pow(s,s)*Math.pow(ro,i))/factorielleRecursive(s))*getQ0();
        }
    }
    @Override
    public double getLq(){
        return getQ0()*((Math.pow(ro*s,getS())*ro)/(factorielleRecursive(s)*(Math.pow(1-ro,2))));
    }

    @Override
    public double getWq(){
        return getLq()/getLambda();
    }

    @Override
    public double getW(){
        return getWq()+(1/getMu());
    }

    @Override
    public double getL(){
        return getLambda()*getW();
    }

    @Override
    public double getTau(float t){
        return (getQ0()*(Math.pow(getRo()*getS(),getS())));
    }
}