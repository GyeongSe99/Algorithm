package finalSwimmingCompetition;
// 수영대회 결승전

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static class Player {
        int r, c, time;

        Player(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    private static int N;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] visited = new int[N][N];
            Queue<Player> q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 시작점 셋팅
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            Player start = new Player(s1, s2, 0);
            q.add(start);

            // 도착점 셋팅
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            map[e1][e2] = 3;
            int answer = -1;

            out : while (!q.isEmpty()) {
                Player cur = q.poll();

                for (int i = 0; i < d.length; i++) {
                    int nr = cur.r + d[i][0];
                    int nc = cur.c + d[i][1];

                    if (checkBorder(nr, nc)) {
                        if (map[nr][nc] == 3) {
                            // 다음에 도착한다는 뜻 이므로 break
                            answer = cur.time + 1;
                            break out;
                        } else if (map[nr][nc] == 2 && visited[nr][nc] == 0) { // 다음 갈 곳이 소용돌이라면
                            // 현재 time 체크
                            if (cur.time % 3 == 2) {
                                visited[nr][nc] = cur.time + 1;
                                q.add(new Player(nr, nc, cur.time + 1));
                            } else {
                                q.add(new Player(cur.r, cur.c, cur.time + 1));
                            }
                        } else if (map[nr][nc] == 0){
                            if (visited[nr][nc] == 0) {
                                visited[nr][nc] = cur.time + 1;
                                q.add(new Player(nr, nc, cur.time + 1));
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static boolean checkBorder(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
