import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            boolean isValid = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
