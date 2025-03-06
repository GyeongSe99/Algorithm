import java.util.LinkedList;
import java.util.Queue;

public class PG_169199 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N, M;
    private static char[][] field;
    private static boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        field = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            field[i] = board[i].toCharArray();
        }

        N = field.length;
        M = field[0].length;
        visited = new boolean[N][M];

        // 시작점 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'R') {
                    return bfs(i, j);
                }
            }
        }
        return answer;
    }

    private int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (field[cur[0]][cur[1]] == 'G') {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int prevR = cur[0];
                int prevC = cur[1];
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                while (isValid(nr, nc) && field[nr][nc] != 'D') {
                    prevR = nr;
                    prevC = nc;
                    nr += dr[i];
                    nc += dc[i];
                }

                if (!visited[prevR][prevC]) {
                    visited[prevR][prevC] = true;
                    q.add(new int[]{prevR, prevC, cur[2] + 1});
                }
            }
        }

        return -1;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}
