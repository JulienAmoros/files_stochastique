package model;

public interface kendal {
     float getLambda();
     float getMu();
     float getRo();

     void setLambda(float lambda);
     void setMu(float mu);

     void MAJRo();
     double getQ0();
     double getL();
     double getLq();
     double getW();
     double getWq();
     double getQi(int i);
     double getTau(float t);
}
