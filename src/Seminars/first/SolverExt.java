package Seminars.first;

import Seminars.first.collections.ArrayStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Вычислить инфиксное арифметическое выражение — операции могут быть без скобок.
 *
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * 1 + ( 2 + 3 ) * 4 * 5 = 101
 * 1 + 5 * 4 * 5 = 101
 * 1 + 5 * 20 = 101
 * 1 + 100 = 101
 * 20 / 4 = 5
 * (101 - 1) / 5 = 20
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class SolverExt {

    private static final String QUIT = "q";
    private static final char LEFT_PAREN  = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char PLUS        = '+';
    private static final char MINUS       = '-';
    private static final char TIMES       = '*';
    private static final char DIVISION    = '/';

    private static double evaluate(String[] values) {
        HashMap<String, Integer> prec = new HashMap<>();
        prec.put(Character.toString(TIMES),      3);
        prec.put(Character.toString(DIVISION),   3);
        prec.put(Character.toString(PLUS),       2);
        prec.put(Character.toString(MINUS),      2);
        prec.put(Character.toString(LEFT_PAREN), 1);

        ArrayStack<String> operators = new ArrayStack<>();   // операторы при преобразовании в постфиксный вид
        LinkedList<String> postfixList = new LinkedList<>(); // постфиксный вид
        ArrayStack<Double> expression = new ArrayStack<>();  // для вычисления постфиксного выражения

        // Преобразование в постфиксный вид:
        for (String token : values) {
            char charToken = token.charAt(0);
            if (token.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                postfixList.add(token);
            } else if (charToken == LEFT_PAREN) {
                operators.push(token);
            } else if (charToken == RIGHT_PAREN) {
                String topToken = operators.pop();
                while (topToken.charAt(0) != LEFT_PAREN) {
                    postfixList.add(topToken);
                    topToken = operators.pop();
                }
            } else if (charToken == TIMES    ||
                       charToken == DIVISION ||
                       charToken == PLUS     ||
                       charToken == MINUS) {
                while (!operators.isEmpty() && (prec.get(operators.peek()) >= prec.get(token))) {
                    postfixList.add(operators.pop());
                }
                operators.push(token);
            } else {
                throw new NumberFormatException("Unknown symbol");
            }
        }
        while (!operators.isEmpty()) {
            postfixList.add(operators.pop());
        }

        // Решение постфиксного выражения:
        for (String token : postfixList) {
            if (token.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                expression.push(Double.parseDouble(token));
            } else {
                double rightOperand = expression.pop();
                double leftOperand = expression.pop();
                switch (token.charAt(0)) {
                    case TIMES:
                        expression.push(leftOperand * rightOperand);
                        break;
                    case DIVISION:
                        expression.push(leftOperand / rightOperand);
                        break;
                    case PLUS:
                        expression.push(leftOperand + rightOperand);
                        break;
                    case MINUS:
                        expression.push(leftOperand - rightOperand);
                        break;
                    default:
                        throw new ArithmeticException("Illegal operator");
                }
            }
        }
        if (!expression.isEmpty()) {
            return expression.pop();
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
