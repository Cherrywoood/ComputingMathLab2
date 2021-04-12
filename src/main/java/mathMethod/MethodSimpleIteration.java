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

    /**
     * Считает значение функции с номером number
     *
     * @param x - аргумент
     * @return значение функции
     */
    private double f(double x) {
        return Function.getFunctionValue(number, x);
    }

    /**
     * Вычисляет значение эквивалентной функии фи
     * @param x - аргумент функции
     * @return - значение функции в точке х
     */
    private double g(double x) {
        return x+lamda*f(x);
    }

    /**
     * Считает производную первого порядка функции с номером number
     *
     * @param x - аргумент
     * @return значение производной второго порядка
     */
    private double firstDerivativeF(double x) {
        return Function.getFirstDerivative(number, x);
    }

    /**
     * Вычисляет значение производной первого порядка функии фи
     * @param x - аргумент функции
     * @return - значение производной в точке х
     */
    private double firstDerivativeG(double x) {
        return 1+lamda*firstDerivativeF(x);
    }


    /**
     * Метод простой итерации
     * @param epsilon - заданная точность
     * @param a - левый конец отрезка
     * @param b - правый конец отрезка
     */
    public ResultInfo findRoot(double epsilon, double a, double b) {
        List<double[]> table = new ArrayList<>();
        int iter = 0;
        lamda = -1/Math.max(firstDerivativeF(a), firstDerivativeF(b));
        double previousX = a;
        double x = 0;
       if(!checkConvergence(a,b)) return null;
        while (true) {
           if(iter < 1000) {
               ++iter;
               x = g(previousX);
               table.add(new double[]{previousX,x,g(x),f(x),Math.abs(x-previousX)});
               if(Math.abs(x-previousX)<=epsilon) break;
               previousX = x;
           }  else {
               Exception.exp = 2;
              return null;
           }
        }
       return new ResultInfo(x, iter, table);
    }

    /**
     * Проверяет условие сходиости
     * @param a - левый конец отрезка
     * @param b - правый конец отрезка
     * @return true - если условие сходимости выполняется, falsе - если нет
     */
    public boolean checkConvergence(double a, double b) {
        if(Checker.checkExistenceRoot(a,b, number) && checkDerivative(a,b)) return true;
        else {
            return false;
        }
    }

    /**
     * Проверяет, что модуль производной от функции фи меньше 1
     * @param a - левый конец отрезка
     * @param b - правый конец отрезка
     * @return true - если меньше, false - если true
     */
    private boolean checkDerivative(double a, double b) {
        double step = (b - a) / 10;
        while (a < b) {
            if(Math.abs(firstDerivativeG(a)) < 1) {
                a += step;
            } else {
                Exception.exp = 3;
                return false;
            }
        }
        return true;
    }

    /**
     * Выводит таблицу уточнения корня методом простой итерации
     * @param table
     */
    public static void showTable(List<double[]> table) {
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
