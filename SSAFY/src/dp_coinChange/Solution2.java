package dp_coinChange;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2 {
    static int N;
    static int[] dp;
    static int[] coins = {5000, 1000, 500, 100, 50, 10, 5, 1};
    static int[] counts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N / 10 + 1];
            counts = new int[coins.length];

            // 가장 작은 크기의 동전만큼 증가
            for (int j = 1; j < N / 10 + 1; j += coins[coins.length - 1]) {
                dp[j] = dp[j - coins[coins.length - 1]] + 1;
                counts[coins.length - 1]++;

                for (int k = coins.length - 2; k >= 0; k--) {
                    if (j >= coins[k] && dp[j - coins[k]] + 1 < dp[j]) {
                        dp[j] = dp[j - coins[k]] + 1;
                        counts[k]++;

                        if (k < coins.length - 1) {
                            counts[k + 1] -= coins[k] / coins[k + 1];
                        }
                    }
                }
            }

            // 출력부
            sb.append("#").append(i).append(" ").append("\n");

            for (int j = 0; j < coins.length; j++) {
                sb.append(counts[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}