package G_2504;

import java.util.*;

public class Main {

    static Stack<String> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        stack = new Stack<>();

        boolean isValid = true;

        for (int i = 0; i < s.length; i++) {
            String str = s[i];

            if ( str.equals("(") || str.equals("[")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                if (str.equals(")")) {
                    if (calculateInBracket(")", "(", "[") == -1) {
                        isValid = false;
                        break;
                    }
                } else {    // "]"
                    if (calculateInBracket("]", "[", "(") == -1) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty() && isValid) {
            String str = stack.pop();
            if (str.equals("[") || str.equals("(") || str.equals(")") || str.equals("]")) {
                isValid = false;
                break;
            } else {
                sum += Integer.parseInt(str);
            }
        }

        if (isValid) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }

    // return = -1 -> 잘못된 괄호
    // str = 현재 들어온 닫는 괄호
    // pair = 현재 들어온 닫는 괄호와 짝을 이루는 여는 괄호
    // notPair = 현재 들어온 닫는 괄호와 짝을 이루지 않는 괄호
    static int calculateInBracket(String str, String pair, String notPair) {
        if (!stack.contains(pair)) {
            return -1;
        }

        int result = 0;
        int value = str.equals(")") ? 2 : 3;

        if (stack.peek().equals(pair)) {
            stack.pop();
            stack.push(String.valueOf(value));
            return value;
        } else {
            while (!stack.isEmpty()) {
                String now = stack.pop();
                if (now.equals(notPair)) {
                    return -1;
                } else if (now.equals(pair)){
                    stack.push(String.valueOf(result * value));
                    return result;
                } else {
                    result += Integer.parseInt(now);
                }
            }
        }

        return -1;
    }
}

