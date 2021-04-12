package cheker;

import mathMethod.Exception;
import functions.Function;

public class Checker {

    public static boolean checkExistenceRoot(double a, double b, int number) {
        double funcA = Function.getFunctionValue(number, a);
        double funcB = Function.getFunctionValue(number, b);
        if (funcA * funcB < 0) {
            return true;
        } else {
            Exception.exp = 4;
            return false;
        }
    }


}
