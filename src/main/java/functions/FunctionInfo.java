package functions;

public class FunctionInfo {
    private double a;
    private double b;
    private double  accuracy;
    private int numberFunction;

    public FunctionInfo(double a, double b, double accuracy, int numberFunction) {
        this.a = a;
        this.b = b;
        this.accuracy = accuracy;
        this.numberFunction = numberFunction;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getNumberFunction() {
        return numberFunction;
    }

    public void setNumberFunction(int numberFunction) {
        this.numberFunction = numberFunction;
    }
}
