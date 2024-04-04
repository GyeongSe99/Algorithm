package backpack;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물건의 개수
        int W = sc.nextInt(); // 배낭의 무게

        int[] weights = new int[N+1];
        int[] cost = new int[N+1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][W + 1]; // i번까지의 물건을 고려하고, w무게 만큼만
        // 물건은 한개씩만 존재한다.
        for (int i = 1; i <= N; i++) {
            // 1 ~ i번 까지 물건을 고려
            // 임시 무게 w
            for (int w = 0; w <= W; w++) {
                // 내가 고려해야 될 i번째의 물건의 무게가, 임시무게보다 적다면
                // 이 물건을 넣을지 말지 고민해야함.
                if (weights[i] <= w) {
                    // 현재 w무게에서의 최적해 dp[i-1][w]
                    // 이번 물건 i를 고려한다면 최적해 dp[i-1][w-weights[i]+cost[i]]
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);

                } else {
                    // 현재 가방에 물건을 더 넣을 수 없다면
                    // 이전 물건까지 고려한 값을 가져오기
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        System.out.println(dp[N][W]);
    }
}
