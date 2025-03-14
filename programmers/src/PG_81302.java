import java.util.LinkedList;
import java.util.Queue;

public class PG_81302 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            if (isValidPlace(places[t])) {
                answer[t] = 1;
            } else {
                answer[t] = 0;
            }
        }

        return answer;
    }

    private boolean isValidPlace(String[] place) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!check(place, r, c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean check(String[] place, int r, int c) {
        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            int dist = poll[2];

            // 주변 탐색 시 사람이면
            if (dist >= 1 && place[cr].charAt(cc) == 'P') {
                return false;
            }

            if (dist < 2) {
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                        if (place[nr].charAt(nc) != 'X') {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc, dist + 1});
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PG_81302 solution = new PG_81302();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution1 = solution.solution(places);
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }
        System.out.println();
    }
}