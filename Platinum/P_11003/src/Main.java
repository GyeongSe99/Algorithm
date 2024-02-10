import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // int[] = {인덱스, 값}
        Deque<int[]> arr = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int[] now = {i, Integer.parseInt(st.nextToken())};

            while (!arr.isEmpty() && arr.peekLast()[1] > now[1]) {
                arr.pollLast();
            }
            arr.addLast(now);

            if (i - arr.peekFirst()[0] >= L) {
                arr.pollFirst();
            }

            sb.append(arr.peekFirst()[1]).append(" ");

        }

        System.out.println(sb);
    }
}