package functions;

public class Function {

    /**
     * Считает функции в зависимости от ее номера
     * @param number - номер функции
     * @param x - аргумент
     * @return значение функции
     */
    public static double getFunctionValue(int number, double x) {
        switch (number) {
            case 1:
                return Math.pow(x,3)-0.2*Math.pow(x,2)+0.5*x+1.5;
            case 2:
                return Math.pow(Math.E,2*x)+3*x-4;
            case 3:
                return Math.sin(3*x)/x;
            default: return 0;
        }
    }

    /**
     * Считает производную первого порядка функции в зависимости от ее номера
     * @param number - номер функции
     * @param x - аргумент
     * @return значение производной первого порядка
     */
    public static double getFirstDerivative(int number, double x) {
        switch (number) {
            case 1:
                return 3*Math.pow(x,2)-0.4*x+0.5;
            case 2:
                return 2*Math.pow(Math.E,2*x)+3;
            case 3:
                return  3*Math.cos(3*x)/x - Math.sin(3*x)/Math.pow(x,2);
            default: return 0;
        }
    }

    /**
     * Считает производную второго порядка функции в зависимости от ее номера
     * @param number - номер функции
     * @param x - аргумент
     * @return значение производной второго порядка
     */
    public static double getSecondDerivative(int number, double x) {
        switch (number) {
            case 1:
                return 6*x-0.4;
            case 2:
                return 4*Math.pow(Math.E,2*x);
            case 3:
                return -9*Math.sin(3*x)/x - 6*Math.cos(3*x)/Math.pow(x,2) + 2*Math.sin(3*x)/Math.pow(x,3);
            default: return 0;
        }
    }

    public static String getFunctionString(int number) {
        switch (number) {
            case 1:
                return "x^3-0.2x^2+0.5x+1.5";
            case 2:
                return "e^(2x)+0.5x+1.5";
            case 3:
                return "sin(3x)/x";
            default: return "";
        }
    }
}
