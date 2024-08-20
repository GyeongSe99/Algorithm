// 균형잡힌 세상

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S_4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack;
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");

        StringBuilder sb = new StringBuilder();

        out : while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;

            String[] split = s.split("");

            stack = new Stack<>();

            for (int i = 0; i < split.length; i++) {
                String str = split[i];

                if (map.containsKey(str)) { // 닫는 괄호에 해당한다면
                    if (!stack.isEmpty() && stack.peek().equals(map.get(str))) {
                        stack.pop();
                    } else {
                        sb.append("no").append("\n");
                        continue out;
                    }
                } else {
                    if (str.equals("(") || str.equals("[")) {   // 여는 괄호에 해당한다면
                        stack.push(str);
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
