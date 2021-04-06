package mathMethod;

import cheker.Checker;
import functions.Function;

import java.util.ArrayList;
import java.util.List;
import java.lang.System;
public class MethodChord {
    private final int number;
    public MethodChord(int number) {
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
     * Считает производную второго порядка функции с номером number
     *
     * @param x - аргумент
     * @return значение производной второго порядка
     */
    private double secondDerivative(double x) {
        return Function.getSecondDerivative(number, x);
    }

    private double firstDerivative(double x) {
        return Function.getFirstDerivative(number, x);
    }

    /**
     * Метод Хорд
     *
     * @param epsilon - заданная точность
     * @param a       - левый конец отрезка
     * @param b       - правый конец отрезка
     */
    public void findRoot(double epsilon, double a, double b) {
        System.out.println("МЕТОД ХОРД:");
        List<double[]> table = new ArrayList<>();
        int iter = 0;
        if(!checkConvergence(a, b)) return;
        double xi = a - (b-a)*f(a)/(f(b)-f(a));
        double previousX = xi;
        while (true) {
            if(iter < 1000) {
                ++iter;
                if(f(xi)*f(a) < 0) {
                    b = xi;
                } else {
                    a = xi;
                }
                xi = a - (b-a)*f(a)/(f(b)-f(a));
                table.add(new double[]{a, b, xi, f(a), f(b), f(xi), Math.abs(xi - previousX)});
                if(Math.abs(xi - previousX) <= epsilon || Math.abs(f(xi)) <= epsilon) break;
                previousX = xi;
            } else {
                System.out.println("Количество решений достигло 1000, решений не найдено");
                return;
            }
        }
        System.out.printf("Количество итераций: %d\n", iter);
        System.out.println("Корень уравнения: " + xi);
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
            if (firstDerivative(a) * firstDerivative(a + step) > 0) {
                a += step;
            } else {
                System.out.printf("Производная меняет знак на промежутке [%f,%f]\n", a, a + step);
                return false;
            }
        }
        return true;
    }

    /**
     * Выводит таблицу уточнения корня методом хорд
     *
     * @param table
     */
    private void showTable(List<double[]> table) {
        int iter = 0;
        String[] heading = {"№ итерации", "a", "b", "x", "f(a)", "f(b)", "f(x)", "|x(i+1)-x(i)|"};
        for (String name : heading) {
            System.out.printf("|%10s ", name);
        }
        System.out.println();
        for (double[] row : table) {
            System.out.printf("|%10d ", ++iter);
            for (double el : row) {
                System.out.printf("|%10.5f ", el);
            }
            System.out.println();
        }
    }


    /* chooseInitialApproximation(a, b);
        double x = fixedBorder ? b : a;
        double previousX;
        do {
            previousX = x;
            // System.out.printf("xi+1 = %f, xi = %f, a = %f, b = %f\n", x, previousX, a, b);
            if (fixedBorder) {
                b = previousX;
                x = b - (a - b) / (f(a) - f(b)) * f(b);
            } else {
                a = previousX;
                x = a - (b - a) / (f(b) - f(a)) * f(a);
            }
            //System.out.printf("xi+1 = %f, xi = %f, a = %f, b = %f\n", x, previousX, a, b);
            table.add(new double[]{iter, a, b, x, f(a), f(b), f(x), Math.abs(x - previousX)});
            ++iter;
        } while ((!(Math.abs(x - previousX) <= epsilon)));

    /**
     * Выбор начального приближения х0
     *
     * @param a - левый конец отрезка
     * @param b - правый конец отрезка

    private void chooseInitialApproximation(double a, double b) {
        System.out.printf("f(a) = f(%f) = %f\t f\'\'(a) = f\'\'(%f) = %f\n",
                a, f(a), a, secondDerivative(a));
        System.out.printf("f(b) = f(%f) = %f\t f\'\'(b) = f\'\'(%f) = %f\n",
                b, f(b), b, secondDerivative(b));
        if (f(a) * secondDerivative(a) > 0) {
            fixedBorder = true;
            System.out.printf("Фиксируем левый конец, x0 = b = %f\n", b);
        } else if (f(b) * secondDerivative(b) > 0) {
            fixedBorder = false;
            System.out.printf("Фиксируем правый конец, x0 = a = %f\n", a);
        } else {
            System.out.println("Не выполнено условие быстрой сходимости");
            System.exit(0);
        }
    } */
}
