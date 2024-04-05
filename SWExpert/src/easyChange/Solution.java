package easyChange;
// 1970 : 쉬운 거스름돈

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] changes = {1, 5, 10, 50, 100, 500, 1000, 5000};

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            N = N / 10;

            int[][] dp = new int[changes.length][N + 1];
            int[] result = new int[changes.length];


            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }
            result[0] = N;

            for (int i = 1; i < changes.length; i++) {
                for (int j = 1; j <= N; j++) {
                    int minCnt = dp[i-1][j];

                    if (j >= changes[i]) {
                        int change = dp[i][j - changes[i]] + 1;
                        if (minCnt > change) {
                            dp[i][j] = change;
                        } else {
                            dp[i][j] = minCnt;
                        }
                    }

                    System.out.println(dp[i][j]);
                }
                System.out.println("----------------------------");
                result[i - 1] = ((result[i - 1] * changes[i - 1]) - dp[i][N] * changes[i]) / changes[i - 1];
                result[i] = dp[i][N];
           }

            StringBuffer sb = new StringBuffer("#" + test_case + " \n");
            for (int i = result.length - 1; i >= 0; i--) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
