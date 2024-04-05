package easyChange;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] change = {1, 5, 10, 50, 100, 500, 1000, 5000};
        int[] dp;
        int[][] cnt;
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt() / 10;

            dp = new int[N + 1];
            cnt = new int[N + 1][];

            //dp[0] = 0;
            cnt[0] = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

            for (int n = 1; n <= N; n++) {
                int min = 50000000;
                int[] minCount = new int[8];
                int minChange = -1;

                for (int j = 0; j < change.length; j++) {
                    if (n - change[j] < 0)
                        continue;
                    if (min > dp[n - change[j]] + 1) {
                        min = dp[n - change[j]] + 1;
                        minCount = cnt[n - change[j]];
                        minChange = j;
                    }
                }

                dp[n] = min;
                cnt[n] = new int[8];
                for (int i = 0; i < 8; i++) {
                    cnt[n][i] = minCount[i];
                }
                cnt[n][minChange]++;
            }

            System.out.println("#" + tc);
            for (int i = 7; i >= 0; i--) {
                System.out.print(cnt[N][i] + " ");
            }
            System.out.println();
        }
    }
}