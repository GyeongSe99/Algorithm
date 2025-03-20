import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            m = Math.max(m, arr[i]);
        }
        Arrays.sort(arr);

        long l = 1, r = m, max = Integer.MIN_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= N) {
                l = mid + 1;
                max = Math.max(max, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.println(max);

    }
}
