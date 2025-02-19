import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_2468 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int height = 0;
        int max = 0;

        while (height <= maxHeight) {
            int cnt = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > height && !visited[i][j]) {
                        bfs(i, j, height);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
            height++;
        }

        System.out.println(max);
    }

    private static void bfs(int i, int j, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if (arr[nr][nc] > height && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}