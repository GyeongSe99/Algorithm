import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G_15686 {
    private static int N, M, result;
    private static int[][] village;
    private static ArrayList<int[]> houses, chickens;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        village = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                village[i][j] = Integer.parseInt(st.nextToken());
                if (village[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
                if (village[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chickens.size()];

        // 조합을 구한 뒤 최소거리 구하기
        solve(0, 0);

        System.out.println(result);
    }

    private static void solve(int idx, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (int[] point : houses) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (visited[i]) {
                        int dist = Math.abs(point[0] - chickens.get(i)[0]) + Math.abs(point[1] - chickens.get(i)[1]);
                        min = Math.min(min, dist);
                    }

                }
                sum += min;
                if (sum >= result) {
                    return;
                }
            }
            result = Math.min(sum, result);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            visited[i] = true;
            solve(i + 1, cnt + 1);
            visited[i] = false;
        }

    }

}
