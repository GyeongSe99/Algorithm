import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        boolean isValid = true;

        if (s.length() == 1) {
            isValid = false;
        }

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!isValid) break;

            char c = s.charAt(i);

            if ( c == '(') {
                stack.push('+');
                stack.push('(');
            } else if (c == '[') {
                stack.push('+');
                stack.push('[');
            } else if (c == ')') {
                int cal = 1;
                int temp = 0;

                while (!stack.isEmpty()) {
                    char now = stack.pop();
                    if (now == '(') {
                        cal *= 2;
                        stack.push((char)(cal + '0'));
                        break;
                    } else if (now == '+') {
                        if (cal == 1) {
                            cal += temp - 1;
                        } else {
                            cal += temp;
                        }
                        temp = 0;
                    } else if (now == '[') {
                        isValid = false;
                        break;
                    } else {
                        temp += now - '0';
                    }
                }
            } else {
                int cal = 1;
                int temp = 0;

                while (!stack.isEmpty()) {
                    char now = stack.pop();
                    if (now == '[') {
                        cal *= 3;
                        stack.push((char)(cal + '0'));
                        break;
                    } else if (now == '+') {
                        if (cal == 1) {
                            cal += temp - 1;
                        } else {
                            cal += temp;
                        }
                    } else if (now == '(') {
                        isValid = false;
                    } else {
                        temp += now - '0';
                    }
                }
            }
        }

        while (!stack.isEmpty() && isValid){
            char c = stack.pop();
            if (c == '[' || c == '(' || c == ')' || c == ']') {
                isValid = false;
            } else {
                if (c != '+') {
                    int num = c - '0';
                    result += num;
                }
            }
        }

        if (isValid) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}
