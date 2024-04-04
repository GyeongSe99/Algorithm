package G_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Player {
        int r, c, length, hCnt;

        public Player(int r, int c, int length, int hCnt) {
            this.r = r;
            this.c = c;
            this.length = length;
            this.hCnt = hCnt;
        }
    }

    static int N, M, minLength;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] d = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        minLength = Integer.MAX_VALUE;
        visited = new boolean[N][M][2];

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs();

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minLength);
        }

    }

    private static void bfs() {
        Queue<Player> q = new LinkedList<>();
        q.add(new Player(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Player p = q.poll();

            if (p.length > minLength) {
                continue;
            }

            if (p.r == N - 1 && p.c == M - 1) {
                minLength = p.length + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + d[i][0];
                int nc = p.c + d[i][1];

                // 범위안에 있고
                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {

                    // 방문 하지 않았는데
                    if (!visited[nr][nc][p.hCnt]) {
                        // 다음으로 갈 곳이 그냥 길이면
                        if (map[nr][nc] == 0) {
                            visited[nr][nc][p.hCnt] = true;
                            q.add(new Player(nr, nc, p.length + 1, p.hCnt));
                        } else { // 다음 갈 곳이 벽이면
                            if (p.hCnt > 0) { // 망치가 있다면
                                // 부수고 이동
                                visited[nr][nc][p.hCnt] = true;
                                q.add(new Player(nr, nc, p.length + 1, p.hCnt - 1));
                            }
                        }
                    }
                }
            }
        }
    }
}
