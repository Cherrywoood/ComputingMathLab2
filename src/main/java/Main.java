import functions.Function;
import functions.FunctionInfo;
import input.ConsoleInput;
import mathMethod.*;
import mathMethod.Exception;

public class Main {
    public static void main(String... arg) {
        FunctionInfo functionInfo = ConsoleInput.input();
        int number = functionInfo.getNumberFunction();
        double a = functionInfo.getA();
        double b = functionInfo.getB();
        double epsilon = functionInfo.getAccuracy();


        if (number <= 3) {
            System.out.println("МЕТОД ХОРД:");
            MethodChord methodChord = new MethodChord(number);
            ResultInfo resultInfo = methodChord.findRoot(epsilon,a,b);
            if(resultInfo != null) {
                MethodChord.showTable(resultInfo.getTable());
                System.out.println("Корень уравнения: " + resultInfo.getX());
            } else {
                Exception.outputExp();
            }
            System.out.println();
            System.out.println("МЕТОД ПРОСТЫХ ИТЕРАЦИЙ");
            MethodSimpleIteration methodSimpleIteration =  new MethodSimpleIteration(number);
            resultInfo = methodSimpleIteration.findRoot(epsilon,a,b);
            if(resultInfo != null) {
                MethodSimpleIteration.showTable(resultInfo.getTable());
                System.out.println("Корень уравнения: " + resultInfo.getX());
            }  else {
                Exception.outputExp();
            }
        } else {
           MethodNewton methodNewton =  new MethodNewton(number);
           ResultInfoSystem resultInfoSystem = methodNewton.findRoots(epsilon, a, b);
            if(resultInfoSystem != null) {
                MethodSimpleIteration.showTable(resultInfoSystem.getTable());
                System.out.println("Корни уравнения: x1 = " + resultInfoSystem.getX1() + " x2 = " + resultInfoSystem.getX2());
            }  else {
                Exception.outputExp();
            }
        }

    }
}
