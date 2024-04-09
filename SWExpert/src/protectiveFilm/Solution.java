package protectiveFilm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    // D: R, W: C, K: 합격기준
    private static int minCnt, R, C, K;
    private static int[][] film;
    private static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            minCnt = Integer.MAX_VALUE;

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[R][C];
            A = new int[C];
            B = new int[C];

            Arrays.fill(B, 1);

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0);


            System.out.println("#" + test_case + " " + minCnt);
        }
    }

    private static void dfs(int drug, int idx, int drugCnt) {
        // 최소 약품 개수보다 많아질 경우 더 이상 볼 필요가 없으므로 return
        if (drugCnt >= minCnt) {
            return;
        }

        // 마지막까지 다다른경우
        if (idx == R) {
            // 성능 검사 통과시 min값 갱신
            if (check(film)) {
                minCnt =  drugCnt;
            }
            return;
        }

        int[] temp = film[idx];

        // 안칠함
        dfs(2, idx + 1, drugCnt);
        // A로 칠함
        film[idx] = A;
        dfs(0, idx + 1, drugCnt + 1);
        // B로 칠함
        film[idx] = B;
        dfs(1, idx + 1, drugCnt + 1);
        film[idx] = temp;
    }

    // 성능 검사
    private static boolean check(int[][] copy) {
        for (int i = 0; i < C; i++) {
            int main = 0;
            int compare = main + 1;
            int cnt = 1;
            boolean isPossible = false;

            while (main < R && compare < R) {
                if (copy[main][i] == copy[compare][i]) {
                    cnt++;
                    compare++;
                } else {
                    main = compare;
                    compare++;
                    cnt = 1;
                    if (R - main < K) break;
                }

                if (cnt >= K) {
                    isPossible = true;
                    break;
                }
            }

            // while문을 다 돌았다는 것은 인덱스 끝까지 다 돌았는데 isPossible이 false라는 뜻
            // 성능 미달이므로 더 이상 볼 필요없음.
            if (!isPossible) {
                return false;
            }
        }

        return true;
    }

}
