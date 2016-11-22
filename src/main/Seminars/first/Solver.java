package Seminars.first;

import Seminars.first.collections.ArrayStack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вычислить инфиксное арифметическое выражение — все операции в скобках.
 *
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {
    private static final String QUIT = "q";
    private static final char LEFT_PAREN  = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char PLUS        = '+';
    private static final char MINUS       = '-';
    private static final char TIMES       = '*';
    private static final char DIVISION    = '/';

    private static double evaluate(String[] values) {
        ArrayStack<String> expression = new ArrayStack<>();
        for (String token : values) {
            switch (token.charAt(0)) {
                case LEFT_PAREN:
                case PLUS:
                case MINUS:
                case TIMES:
                case DIVISION:
                    expression.push(token);
                    break;
                case RIGHT_PAREN:
                    if (expression.peek().equals(String.valueOf(LEFT_PAREN))) {
                        throw new ArithmeticException("Empty expression inside parents");
                    }
                    double rightOperand = Double.valueOf(expression.pop());
                    String operator = expression.pop();
                    double leftOperand = Double.valueOf(expression.pop());
                    expression.pop(); // "("
                    double result;
                    switch (operator.charAt(0)) {
                        case TIMES:
                            result = leftOperand * rightOperand;
                            break;
                        case DIVISION:
                            result = leftOperand / rightOperand;
                            break;
                        case PLUS:
                            result = leftOperand + rightOperand;
                            break;
                        case MINUS:
                            result = leftOperand - rightOperand;
                            break;
                        default:
                            throw new ArithmeticException("Illegal operator");
                    }
                    expression.push(Double.toString(result));
                    break;
                default:
                    if (token.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                        expression.push(token);
                        break;
                    } else {
                        throw new NumberFormatException("Unknown symbol");
                    }
            }
        }
        if (!expression.isEmpty()) {
            return Double.parseDouble(expression.pop());
        } else {
            return -1.0;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException | ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
