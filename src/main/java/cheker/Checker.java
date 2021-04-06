package cheker;

import functions.Function;

public class Checker {

    public static boolean checkExistenceRoot(double a, double b, int number) {
        double funcA = Function.getFunctionValue(number,a);
        double funcB = Function.getFunctionValue(number,b);
        System.out.printf("f(a) = f(%f) = %f\n", a, funcA);
        System.out.printf("f(b) = f(%f) = %f\n", b, funcB);
        if (funcA * funcB < 0) {
            return  true;
        } else {
            System.out.printf("На отрезке [%f,%f] корня уравнения не существует.", a, b);
            return false;
        }
    }



}
