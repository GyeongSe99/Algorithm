package AlgoTest_graph_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1 {
    private static final int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int N, M, T;
    private static int[][] map;
    private static boolean[][] visited;
    private static int maxVal, firstCat;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxVal = 0;
            firstCat = 0;

            // 입력 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[N][N];

            // 주어진 고양이의 숫자 만큼 반복문 돌기
            for (int catNum = 1; catNum <= M; catNum++) {

                // map을 쭉 돌다가 현재 보려는 고양이의 num과 같은 값이 있으면 bfs탐색.
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == catNum) {
                            // 탐색결과로 연속된 영역의 개수를 리턴한다.
                            int cnt = bfs(i, j, catNum);
                            // 영역의 넓이가 원래 기록되어 있었던 넓이보다 크다면
                            if (maxVal < cnt) {
                                maxVal = cnt;
                                // 대장 고양이 갱신
                                firstCat = catNum;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + firstCat);
        }
    }

    // 탐색결과로 연속된 영역의 개수를 리턴한다.
    private static int bfs(int r, int c, int catNum) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[] {r, c});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + d[i][0];
                int nc = cur[1] + d[i][1];

                // 범위 안에 있고, 방문하지 않았으며, 현재 보는 고양이와 값이 같은 경우
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] == catNum) {
                    cnt++;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        return cnt;
    }
}
