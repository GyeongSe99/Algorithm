import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1421 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 개수
        int C = Integer.parseInt(st.nextToken());   // 나무를 자를 때 드는 비용
        int W = Integer.parseInt(st.nextToken());   // 나무 한 단위의 가격

        int[] woods = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, woods[i]);
        }

        long maxProfit = 0;

        for (int i = 1; i <= max; i++) {
            long total = 0;

            for (int wood: woods) {
                if (wood < i) continue;

                int cnt = wood / i;
                int cutCnt = (wood % i == 0) ? (cnt - 1) : cnt;

                int profit = (cnt * i * W) - (C * cutCnt);

                // 자르는게 이득일 때만 추가
                if (profit > 0) total += profit;
            }

            maxProfit = Math.max(maxProfit, total);
        }

        System.out.println(maxProfit);

        
    }
}
