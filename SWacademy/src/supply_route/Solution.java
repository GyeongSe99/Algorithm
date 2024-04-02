package supply_route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int[][] map, dist;
    static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();

                for (int j = 0; j < N; j++) {
                    map[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = INF;
                }
            }

            dist[0][0] = 0;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + d[i][0];
                    int nc = c + d[i][1];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                        int val = dist[r][c] + map[nr][nc];
                        if (val < dist[nr][nc]) {
                            dist[nr][nc] = val;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + dist[N-1][N-1]);
        }

    }

}
