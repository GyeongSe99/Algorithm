package G_14502;

// 연구소
// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxArea;
    static int[][] lab, copy;
    static boolean[][] dfsVisited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0, 0, 0);

        System.out.println(maxArea);

    }

    static void buildWall(int r, int c, int idx) {
        if (idx == 3) { // 벽을 3개 세웠을때
            copy = new int[N][M];
            dfsVisited = new boolean[N][M];
            for (int i = 0; i < copy.length; i++) {
                System.arraycopy(lab[i], 0, copy[i], 0, copy[i].length);
            }

            // 바이러스 퍼뜨리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 2) {
                        dfs(i, j);
                    }
                }
            }

            // 바이러스가 없는 곳 숫자 세기
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            maxArea = Math.max(cnt, maxArea);
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = i == r ? c : 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    buildWall(i, j, idx + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void dfs(int r, int c) {
        dfsVisited[r][c] = true;
        copy[r][c] = 2;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && copy[nr][nc] == 0 && !dfsVisited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
