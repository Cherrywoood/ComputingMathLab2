package validator;

import java.lang.System;
public class Validator {
    private static final int COUNT_FUNCTION = 5;

    /**
     * Валидация номеров функций
     * @param str - ввод пользователя
     * @return номер, если ввод корректен, 0 - если ошибка
     */
    public static int validateNumberFunction(String str){
        try {
            int n = Integer.parseInt(str);
            if (n < 1 || n > COUNT_FUNCTION) {
                System.err.println("Нет функции с таким номером!");
                return 0;
            }
            return n;
        } catch (NumberFormatException e) {
            System.err.println("Номер - целое число!");
            return 0;
        }
    }

    /**
     * Валидация чисел типа Double
     * @param str - ввод пользователя
     * @return число, если ввод корректен
     */
    public static Double validateDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.err.println("Не является числом!");
            return null;
        }
    }

}
