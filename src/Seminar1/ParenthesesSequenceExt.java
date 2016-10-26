package Seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Seminar1.collections.ArrayStack;

/**
 * Проверить скобочную последовательность на правильность — три вида скобок.
 *
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 *      взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 *      к которой приписана слева или справа правильная скобочная последовательность
 *      — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";
    private static final char LEFT_PARENT    = '(';
    private static final char RIGHT_PARENT   = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        char[] char_sequence = sequence.toCharArray();
        if (    char_sequence[0] != LEFT_PARENT  &&
                char_sequence[0] != RIGHT_PARENT &&
                char_sequence[0] != LEFT_BRACE   &&
                char_sequence[0] != RIGHT_BRACE  &&
                char_sequence[0] != LEFT_BRACKET &&
                char_sequence[0] != RIGHT_BRACKET) {
            return false;
        }
        ArrayStack<Character> brackets = new ArrayStack<>();
        for (char ch : char_sequence) {
            if (ch == LEFT_PARENT || ch == LEFT_BRACKET || ch == LEFT_BRACE) {
                brackets.push(ch);
            } else if (!brackets.isEmpty() && (ch == RIGHT_PARENT || ch == RIGHT_BRACE || ch == RIGHT_BRACKET)) {
                char last = brackets.pop();
                if (ch == RIGHT_BRACKET && last != LEFT_BRACKET) {
                    return false;
                } else if (ch == RIGHT_PARENT && last != LEFT_PARENT) {
                    return false;
                } else if (ch == RIGHT_BRACE && last != LEFT_BRACE) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence; // для очередной строки с консоли
            while (!QUIT.equals(sequence = reader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
