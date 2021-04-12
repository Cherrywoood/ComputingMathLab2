package mathMethod;

import java.util.List;

public class ResultInfoSystem {
    private double x1;
    private double x2;
    private int iter;
    private List<double[]> table;

    public ResultInfoSystem(double x1, double x2, int iter, List<double[]> table) {
        this.x1 = x1;
        this.x2 = x2;
        this.iter = iter;
        this.table = table;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    public List<double[]> getTable() {
        return table;
    }

    public void setTable(List<double[]> table) {
        this.table = table;
    }
}
