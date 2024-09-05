import java.util.*;
import java.io.*;

public class S_1012 {
    private static int N, M, K;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int[][] field;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int cnt = 0;

            field = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][k] == 1) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int r, int c) {
        field[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < field.length && nc >= 0 && nc < field[0].length && field[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

}
