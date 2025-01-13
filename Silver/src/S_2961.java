import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2961 {
    private static int N, min;
    private static int[][] ingredients;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        solve(0, 1, 0, 0);
        System.out.println(min);
    }

    private static void solve(int idx, int sour, int bitter, int count) {
        if (idx == N) {
            if (count > 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료를 선택한 경우
        solve(idx + 1, sour * ingredients[idx][0], bitter + ingredients[idx][1], count + 1);
        // 현재 재료를 선택하지 않은 경우
        solve(idx + 1, sour, bitter, count);
    }
}
