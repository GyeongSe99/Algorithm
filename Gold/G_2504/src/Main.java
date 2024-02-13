import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        boolean isValid = true;

        if (s.length() == 1) {
            isValid = false;
        }

        char prev = '0';

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);
            // 여는 괄호일 경우
            // 아무 연산도 할 수 없으므로 prev를 stack에 넣는다.
            if (cur == '(' || cur == '[') {
                sb.append("+");
                stack.push(cur);
                prev = cur;
            } else if (cur == ')') {
                if (!stack.isEmpty()) {
                    if (prev == '(') {
                        stack.pop();
                        sb.append("2");
                        prev = cur;
                    } else if (prev == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                            sb.append("*").append("2");
                            prev = cur;
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                } else {
                    isValid = false;
                    break;
                }
            } else {

            }
        }
    }
}
