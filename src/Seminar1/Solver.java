package Seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Seminar1.collections.ArrayStack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {
    private static final String QUIT = "q";
    private static final char LEFT_PARENT   = '(';
    private static final char RIGHT_PARENT  = ')';
    private static final char PLUS          = '+';
    private static final char MINUS         = '-';
    private static final char TIMES         = '*';
    private static final char DIVISION      = '/';

    private static double evaluate(String[] values) {
        ArrayStack<String> st = new ArrayStack<>();
        for (String ch : values) {
            switch (ch.charAt(0)) {
                case LEFT_PARENT:
                case PLUS:
                case MINUS:
                case TIMES:
                case DIVISION:
                    st.push(ch);
                    break;
                case RIGHT_PARENT:
                    if (st.peek().equals(String.valueOf(LEFT_PARENT))) {
                        throw new ArithmeticException("Empty expression inside parents");
                    }
                    double rightOperand = Double.valueOf(st.pop());
                    String operator = st.pop();
                    double leftOperand = Double.valueOf(st.pop());
                    st.pop(); // left parent
                    double res;
                    switch (operator.charAt(0)) {
                        case TIMES:
                            res = leftOperand * rightOperand;
                            break;
                        case DIVISION:
                            res = leftOperand / rightOperand;
                            break;
                        case PLUS:
                            res = leftOperand + rightOperand;
                            break;
                        case MINUS:
                            res = leftOperand - rightOperand;
                            break;
                        default:
                            throw new ArithmeticException("Illegal operator");
                    }
                    st.push(Double.toString(res));
                    break;
                default:
                    if (ch.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                        st.push(ch);
                        break;
                    } else {
                        throw new NumberFormatException("Unknown symbol");
                    }
            }
        }
        if (!st.isEmpty()) {
            return Double.parseDouble(st.pop());
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
