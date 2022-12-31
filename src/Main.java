import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение: ");

        try {
            String expr = calc(sc.nextLine());                 //вызываем кальк + обработка исключений
            System.out.print("Выражение равно: " + expr);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String calc(String input) {

        //какие арифметические символы есть
        String[] symbol = {"+", "-", "*", "/"};
        String[] symbolSp = {"\\+", "-", "\\*", "/"}; //дублируем для выделения арифм знака ниже

        int result;

        //Определяем знак операции
        int symbolIndex = -1;
        for (int i = 0; i < symbol.length; i++) {
            if (input.contains(symbol[i])) {
                symbolIndex = i;
                //System.out.println(symbol[i]);
                //System.out.println(symbolIndex);
                break;
            }
        }

        if (symbolIndex == -1) {
            throw new ArrayIndexOutOfBoundsException("Введенное выражение не является математической операцией");
        }
        //Выделяем цифры из введенной строки и обрабатываем исключение
        String[] number = input.split(" " + (symbolSp[symbolIndex]) + " ");

        if (number.length > 2) {
            throw new NumberFormatException("Формат матем. операции не удовлетворяет заданию");
            }

        //перевод строки в значения инт + выброс исключения, если введены некорректные данные
        int a = Integer.parseInt(number[0]);
        int b = Integer.parseInt(number[1]);

        //условие на ввод чисел от 1 и до 10
        if (a <= 10 && a >= 1 && b <= 10 && b >= 1) {
            //Выбор символа операции и выполнение самой операции
            result = switch (symbol[symbolIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };

        } else {
            throw new NumberFormatException("Введены числа не удовлетворяющие заданию");
        }

        return String.valueOf(result);
    }


}