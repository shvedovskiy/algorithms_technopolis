package Seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Проверить скобочную последовательность на правильность — один вид скобок.
 *
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 *      взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 *      к которой приписана слева или справа правильная скобочная последовательность
 *      — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequence {
    private static final String QUIT = "q";
    private static final char LEFT_PARENT = '(';
    private static final char RIGHT_PARENT = ')';

    // sequence = "()()" | "((((" | ")()(" | ...
    private static boolean isBalanced(String sequence) {
        char[] char_sequence = sequence.toCharArray();
        if (char_sequence[0] != LEFT_PARENT && char_sequence[0] != RIGHT_PARENT) {
            return false;
        }
        int counter = 0;
        for (char ch : char_sequence) {
            if (counter < 0) {
                break;
            }
            if (ch == LEFT_PARENT) {
                counter++;
            } else if (ch == RIGHT_PARENT) {
                counter--;
            } else {
                return false;
            }
        }
        return (counter == 0);
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
