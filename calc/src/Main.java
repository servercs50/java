
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        while(!expression.equals("/exit")) {
            // System.out.println(Calculator.ExpressionToRPN("5++6"));
            System.out.println("Ответ: " + Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));
            System.out.println("Введите выражение:");
            expression = scanner.nextLine();
        }
    }
}


