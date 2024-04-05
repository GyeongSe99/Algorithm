package S_14916;
// 거스름돈

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] changes = {2, 5};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = N > 5 ? new int[N + 1] : new int[6];

        dp[1] = 987654321;
        dp[2] = 1;
        dp[3] = 987654321;
        dp[4] = 2;

        for (int i = 1; i < N + 1; i++) {
            int min = 987654321;

            for (int j = 0; j < changes.length; j++) {
                if (i - changes[j] < 0) continue;
                int temp = dp[i - changes[j]] + 1;
                if (min > temp) {
                    min = temp;
                }
            }

            dp[i] = min;
        }

        System.out.println(dp[N] == 987654321 ? -1 : dp[N]);
    }
}
