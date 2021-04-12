package input;

import drawingGraph.FunctionGraph;
import functions.Function;
import functions.FunctionInfo;
import functions.SystemOfFunction;
import validator.Validator;

import java.util.Scanner;
import java.lang.System;
public class ConsoleInput {


    public static FunctionInfo input(){
        Scanner scanner = new Scanner(System.in);

        int numberFunction = 0;
        do {
            System.out.println("Выберите уравнение или систему уравнений:\n" +
                    "1. х^3 – 0,2x^2 + 0,5x + 1,5 = 0\n" +
                    "2. e^(2x) + 3x - 4 = 0\n" +
                    "3. sin(x) + 0.1x^2 = 0\n" +
                    "4.\n" +
                    "| sin(x1) - x2 - 1.32 = 0\n" +
                    "| e^(x1) - x2 - 8 = 0\n" +
                    "5.\n" +
                    "| x1 + x2 - 4 = 0\n" +
                    "| (x1)^2 - 4(x2) + 0.85 = 0");
            numberFunction = Validator.validateNumberFunction(scanner.nextLine());
        }
        while (numberFunction == 0);

        FunctionGraph functionGraph = new FunctionGraph(numberFunction);
        if(numberFunction <= 3) functionGraph.drawGraphFunction(Function.getFunctionString(numberFunction));
        else functionGraph.drawGraphSystem(SystemOfFunction.getFunctionString(numberFunction)[0],
                SystemOfFunction.getFunctionString(numberFunction)[1]);

        Double a = null;
        do {
            if(numberFunction <= 3)System.out.println("Введите левую границу отрезка:");
            else System.out.println("Введите начальное приблежение для x1");
               a = Validator.validateDouble(scanner.nextLine().replace(',','.'));
        }
        while (a == null);

        Double b = null;
        do {

            if(numberFunction <= 3)System.out.println("Введите правую границу отрезка:");
            else System.out.println("Введите начальное приблежение для x2");
            b = Validator.validateDouble(scanner.nextLine().replace(',','.'));
        }
        while (b == null);

        Double accuracy = null;

        do {
            System.out.println("Введите точность:");
            accuracy = Validator.validateDouble(scanner.nextLine().replace(',','.'));
        }
        while (accuracy == null);

        return new FunctionInfo(a,b,accuracy,numberFunction);
    }
}
