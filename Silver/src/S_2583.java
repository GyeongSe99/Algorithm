import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S_2583 {

    private static int M, N, K, cnt, sum;
    private static int[][] map, visited;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {-1, 1, 0, 0};
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new int[M][N];

        // 직사각형 색칠
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    dfs(i, j);
                    cnt++;
                    result.add(sum);
                    sum = 0;
                }
            }
        }

        System.out.println(cnt);
        result.stream().sorted().forEach(e -> System.out.print(e + " "));
    }

    private static void dfs(int r, int c) {
        sum++;
        // 더이상 갈곳이 없으면 return


        // 다음 갈 곳 확인
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 다음 갈 좌표가 범위 안에 있지 않으면 skip
            if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
                continue;
            }

            // 다음 갈 좌표가 흰색(0)이고 방문하지 않았으면 방문
            if (map[nr][nc] == 0 && visited[nr][nc] == 0) {
                visited[nr][nc] = 1;

                dfs(nr, nc);
            }
        }


    }
}
