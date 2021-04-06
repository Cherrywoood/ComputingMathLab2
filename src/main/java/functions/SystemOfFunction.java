package functions;

public class SystemOfFunction {


    public static double getFunctionOneOfSystem(int number, double x1, double x2) {
        switch (number) {
            case 4:
                return Math.sin(x1) - x2 - 1.32;
            case 5:
                return x1 + x2 - 4;
            default:
                return 0;
        }
    }

    public static double getFunctionTwoOfSystem(int number, double x1, double x2) {
        switch (number) {
            case 4:
                return Math.pow(Math.E,x1)-8-x2;
            case 5:
                return Math.pow(x1,2) - 4*x2 + 0.85;
            default:
                return 0;
        }
    }
    public static String[] getFunctionString(int number) {
        switch (number) {
            case 4:
                return new String[]{"sin(x) - 1.32","e^x-8"};
            case 5:
                return new String[] {"4-x","(x^2+0.85)/4"};
            default: return new String[2];
        }
    }
    public static double[] getFunction(int number, double x) {
        switch (number) {
            case 4:
                return new double[]{Math.sin(x)-1.32,Math.pow(Math.E,x)-8};
            case 5:
                return new double[]{4-x,(Math.pow(x,2)+0.85)/4};
            default: return new double[2];
        }
    }

    public static double[] getPartialDerivatives1(int number, double x1, double x2) {
        switch (number) {
            case 4:
                return new double[]{Math.cos(x1), -1};
            case 5:
                return new double[]{1,1};
            default:
                return new double[2];
        }
    }

    public static double[] getPartialDerivatives2(int number, double x1, double x2) {
        switch (number) {
            case 4:
                return new double[]{Math.pow(Math.E,x1), -1};
            case 5:
                return new double[]{2*x1,-4};
            default:
                return new double[2];
        }
    }

}
