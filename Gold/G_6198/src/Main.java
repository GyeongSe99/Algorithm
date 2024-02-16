import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            list[i] = n;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        long sum = 0;

        for (int i = 1; i < list.length; i++) {
            int now = list[i];

            while (!stack.isEmpty()) {
                if (list[stack.peek()] <= now) {
                    sum += Math.abs(i - 1 - stack.pop());
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        int lastIdx = list.length;
        while (!stack.isEmpty()) {
            sum += Math.abs(lastIdx - 1 - stack.pop());
        }

        System.out.println(sum);
    }
}
