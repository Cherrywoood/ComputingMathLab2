package mathMethod;

import functions.SystemOfFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.System;

public class MethodNewton {
    private int number;

    public MethodNewton(int number) {
        this.number = number;
    }

    private double f1(double x1, double x2) {
        return SystemOfFunction.getFunctionOneOfSystem(number, x1, x2);
    }

    private double f2(double x1, double x2) {
        return SystemOfFunction.getFunctionTwoOfSystem(number, x1, x2);
    }

    private double[] partialDerivatives1(double x1, double x2) {
        return SystemOfFunction.getPartialDerivatives1(number, x1, x2);
    }

    private double[] partialDerivatives2(double x1, double x2) {
        return SystemOfFunction.getPartialDerivatives2(number, x1, x2);
    }

    private double detJ(double x1, double x2) {
        double[] partialDerivatives1 = partialDerivatives1(x1, x2);
        double[] partialDerivatives2 = partialDerivatives2(x1, x2);
        return partialDerivatives1[0] * partialDerivatives2[1] - partialDerivatives1[1] * partialDerivatives2[0];
    }

    private double[][] inverseJ(double x1, double x2) {
        double[] partialDerivatives1 = partialDerivatives1(x1, x2);
        double[] partialDerivatives2 = partialDerivatives2(x1, x2);
        double detJ = partialDerivatives1[0] * partialDerivatives2[1] - partialDerivatives1[1] * partialDerivatives2[0];
        if (detJ != 0) {
            return new double[][]{{partialDerivatives2[1] / detJ, -partialDerivatives1[1] / detJ},
                    {-partialDerivatives2[0] / detJ, partialDerivatives1[0] / detJ}};
        }
        return null;
    }

    public ResultInfoSystem findRoots(double epsilon, double x1_0, double x2_0) {
        int iter = 0;
        double x1 = 0;
        double x2 = 0;
        double previousX1 = x1_0;
        double previousX2 = x2_0;
        List<double[]> table = new ArrayList<>();
        while (true) {
            if (iter < 1000) {
                double[][] inverseJ = inverseJ(previousX1, previousX2);
                if (inverseJ != null) {
                    ++iter;
                    double h1 = inverseJ[0][0] * f1(previousX1, previousX2) + inverseJ[0][1] * f2(previousX1, previousX2);
                    double h2 = inverseJ[1][0] * f1(previousX1, previousX2) + inverseJ[1][1] * f2(previousX1, previousX2);
                    x1 = previousX1 - h1;
                    x2 = previousX2 - h2;
                    table.add(new double[]{previousX1, previousX2, f1(previousX1, previousX2),
                            f2(previousX1, previousX2), partialDerivatives1(previousX1, previousX2)[0],
                            partialDerivatives2(previousX1, previousX2)[0], partialDerivatives1(previousX1, previousX2)[1],
                            partialDerivatives2(previousX1, previousX2)[1], h1,
                            h2, detJ(previousX1, previousX2)});
                    if (Math.max(Math.abs(x1 - previousX1), Math.abs(x2 - previousX2)) <= epsilon) break;
                    previousX1 = x1;
                    previousX2 = x2;
                } else {
                    Exception.exp = 5;
                    return null;
                }
            } else {
                Exception.exp = 2;
                return null;
            }
        }
        return new ResultInfoSystem(x1,x2,iter,table);

    }

    public static void showTable(List<double[]> table) {
        String[] heading = {"x1", "x2", "f1(x1,x2)", "f2(x1,x2)"
                , "∂f1(x1,y2)∂x1", " ∂f2(x1,y2)∂x1", "∂f1(x1,y2)∂x2", " ∂f2(x1,y2)∂x2",
                "h1", "h2", "detJ"};
        int iter = 0;
        System.out.printf("|%5s ", "k");
        for (String name : heading) {
            System.out.printf("|%15s ", name);
        }
        System.out.println();
        for (double[] row : table) {
            System.out.printf("|%5d ", ++iter);
            for (double el : row) {
                System.out.printf("|%15.5f ", el);
            }
            System.out.println();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
