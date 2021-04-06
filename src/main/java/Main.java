import functions.FunctionInfo;
import input.ConsoleInput;
import mathMethod.MethodChord;
import mathMethod.MethodNewton;
import mathMethod.MethodSimpleIteration;

public class Main {
    public static void main(String... arg) {
        FunctionInfo functionInfo = ConsoleInput.input();
        int number = functionInfo.getNumberFunction();
        double a = functionInfo.getA();
        double b = functionInfo.getB();
        double epsilon = functionInfo.getAccuracy();


        if (number <= 3) {
            new MethodChord(number).findRoot(epsilon, a, b);
            new MethodSimpleIteration(number).findRoot(epsilon, a, b);
        } else {
            new MethodNewton(number).findRoots(epsilon, a, b);
            new MethodNewton(number).findRoots2(epsilon, a, b);
        }

    }
}
