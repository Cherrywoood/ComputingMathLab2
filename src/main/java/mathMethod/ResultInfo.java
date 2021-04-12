package mathMethod;

import java.util.List;

public class ResultInfo {
    private double x;
    private int iter;
    private List<double[]> table;

    public ResultInfo(double x, int iter, List<double[]> table) {
        this.x = x;
        this.iter = iter;
        this.table = table;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
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
