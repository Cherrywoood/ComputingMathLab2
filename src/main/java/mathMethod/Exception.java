package mathMethod;

public class Exception {
    public static int exp;

    public static void outputExp() {
        switch (exp) {
            case 1:
                System.out.println("Функция не монотонная на заданном промежутке");
                break;
            case 2:
                System.out.println("Количество решений достигло 1000, решений не найдено");
                break;
            case 3:
                System.out.println("|g\'(x)| < 1\n Условие сходимости не выполняется");
                break;
            case 4:
                System.out.println("На отрезке [a,b] корня уравнения не существует.");
                break;
            case 5:
                System.out.println("Определитель Якобиана равен нулю");
                break;
            default:

        }
    }
}
