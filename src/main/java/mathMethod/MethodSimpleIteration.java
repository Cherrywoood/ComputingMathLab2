package mathMethod;

import cheker.Checker;
import functions.Function;

import java.util.ArrayList;
import java.util.List;
import java.lang.System;
public class MethodSimpleIteration {
    private final int number;
    private double lamda;


    public MethodSimpleIteration(int number) {
        this.number = number;
    }
    private double f(double x) {
        return Function.getFunctionValue(number, x);
    }
    private double g(double x) {
        return x+lamda*f(x);
    }
    private double firstDerivativeF(double x) {
        return Function.getFirstDerivative(number, x);
    }
    private double firstDerivativeG(double x) {
        return 1+lamda*firstDerivativeF(x);
    }

    public void findRoot(double epsilon, double a, double b) {
        System.out.println("МЕТОД ПРОСТЫХ ИТЕРАЦИЙ");
        List<double[]> table = new ArrayList<>();
        int iter = 0;
        System.out.printf("f\'(a) = f\'(%f) = %.5f\n",a,firstDerivativeF(a));
        System.out.printf("f\'(b) = f\'(%f) = %.5f\n",b,firstDerivativeF(b));
        lamda = -1/Math.max(firstDerivativeF(a), firstDerivativeF(b));
        System.out.println("Lamda: " + lamda);
        double previousX = a;
        double x;
        if(!checkConvergence(a,b)) return;
        while (true) {
           if(iter < 1000) {
               ++iter;
               x = g(previousX);
               table.add(new double[]{iter,previousX,x,g(x),f(x),Math.abs(x-previousX)});
               if(Math.abs(x-previousX)<=epsilon) break;
               previousX = x;
           }  else {
               System.out.println("Количество решений достигло 1000, решений не найдено");
               return;
           }
        }
        System.out.printf("Количество итераций: %d\n", iter);
        System.out.println("Корень уравнения: " + x);
        showTable(table);
    }

    public boolean checkConvergence(double a, double b) {
        if(Checker.checkExistenceRoot(a,b, number) && checkDerivative(a,b)) return true;
        else {
            System.out.println("Условие сходимости не выполняется");
            return false;
        }
    }
    private boolean checkDerivative(double a, double b) {
        double step = (b - a) / 10;
        while (a < b) {
            if(Math.abs(firstDerivativeG(a)) < 1) {
                a += step;
            } else {
                System.out.printf("g\'(x) = g\'(%f) = %f > 1\n",a,firstDerivativeG(a));
                return false;
            }
        }
        return true;
    }
    private void showTable(List<double[]> table) {
        int iter = 0;
        String [] heading = {"№ итерации", "x(i)", "x(i+1)", "g(x(i+1))", "f(x(i+1))", "|x(i+1)-x(i)|" };
        for (String name:heading) {
            System.out.printf("|%10s ", name);
        }
        System.out.println();
        for (double [] row: table) {
            System.out.printf("|%10d ", ++iter);
            for (double el: row) {
                System.out.printf("|%10.5f ", el);
            }
            System.out.println();
        }
    }
}
