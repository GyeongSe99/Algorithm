// Parametric Search

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max;
        int answer = 0;
        while(left <= right) {
            int m = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > m) {
                    sum += arr[i] - m;
                }
            }

            // 너무 많이 잘랐을 경우 높이를 좀 더 높게 해야함.
            if (sum >= M) {
                answer = m;
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        System.out.println(answer);
    }
}
