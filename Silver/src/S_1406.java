import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_1406 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : br.readLine().toCharArray()) {
            left.push(c);
        }

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (command.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.push(st.nextToken().charAt(0));
            }

        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            sb.append(left.pop());
        }

        sb.reverse();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }

}
