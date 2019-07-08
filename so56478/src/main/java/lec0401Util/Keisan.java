package lec0401Util;

public class Keisan {
    
    private double v1;
    private double v2;

    public Keisan(double v1, double v2) {
        this.v1=v1;
        this.v2=v2;
    }

    public double plus() {
        return v1+v2;
    }

    public double divide() {
        return v1/v2;
    }

    public double minus() {
        return v1-v2;
    }

    public double multiply() {
        return v1*v2;
    }

}
