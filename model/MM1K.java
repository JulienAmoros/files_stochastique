public class MM1K{

    private float lambda;
    private float mu;
    private float ro;
    private float k;

    /** Constructor **/
    public MM1(float lambda, float mu, float k) {
        this.lambda = lambda;
        this.mu = mu;
        this.ro = (lambda/mu);
        this.k = this.k;
    }

    /** Getter **/
    public float getLambda() {return lambda;}
    public float getMu() {return mu;}
    public float getRo() {return ro;}
    public float getK() {return k;}


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
    private getQi(){
        if(getRo()==1){
            return (1/(getK()+1));
        }
    }
}