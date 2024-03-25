package G_2636;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visit;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCheeseCnt = 0;

        while (true) {
            time++;

            int cheeseCnt = cheeseCnt();

            if (cheeseCnt == 0) {
                break;
            }
            lastCheeseCnt = cheeseCnt;
            melting(new int[]{0, 0});

            for (int i = 0; i < N; i++) {
                Arrays.fill(visit[i], false);
            }
        }

        System.out.println(time - 1);
        System.out.println(lastCheeseCnt);
    }

    // 0인 부분을 세고
    // 전체에서 0인 부분을 제외한 부분을 cheeseCnt로 판단
    static void melting(int[] rc) {
        Queue<int[]> q = new LinkedList<>();
        visit[rc[0]][rc[1]] = true;
        q.add(rc);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visit[nr][nc]) {
                        if (board[nr][nc] == 1) {
                            board[nr][nc] = -1;
                            visit[nr][nc] = true;
                        }

                        if (board[nr][nc] == 0) {
                            visit[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    static int cheeseCnt() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}