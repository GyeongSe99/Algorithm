import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 3];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 3];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];

        // arr[0] + arr[2] -> 두번째 잔을 마시지 않은 경우
        // arr[1] + arr[2] -> 첫번째 잔을 마시지 않은 경우
        // dp[1] -> 현재 잔(arr[2])을 마시지 않은 경우
        dp[2] = Math.max(Math.max(arr[0] + arr[2], arr[1] + arr[2]), dp[1]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]));
        }
        System.out.println(dp[n - 1]);

    }

}
