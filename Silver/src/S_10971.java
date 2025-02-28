import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_10971 {
    private static int N;
    private static int[][] costsMap;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        costsMap = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costsMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        backtracking(0, 0, 1);
        System.out.println(answer);


    }

    private static void backtracking(int cur, int cost, int cnt) {
        if (cost >= answer) return;
        if (cnt == N && costsMap[cur][0] != 0) {
            answer = Math.min(answer, cost + costsMap[cur][0]);
            return;
        }

        for (int next = 1; next < N; next++) {
            if (!visited[next] && costsMap[cur][next] != 0) {
                visited[next] = true;
                backtracking(next, cost + costsMap[cur][next], cnt + 1);
                visited[next] = false;
            }
        }
    }
}
