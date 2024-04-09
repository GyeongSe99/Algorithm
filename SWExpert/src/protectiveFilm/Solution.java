package protectiveFilm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // D: R, W: C, K: 합격기준
    private static int minCnt, R, C, K;
    private static int[][] film;
    private static int[] drugs;

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
            drugs = new int[R];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 약품 안칠하기
            dfs(2, 0, 0);
            // A 약품 칠하기
            dfs(0, 0, 1);
            // B 약품 칠하기
            dfs(1, 0, 1);


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
            // 약품 바른 카피본
            int[][] copy = copy();

            // 성능 검사 통과시 min값 갱신
            if (check(copy)) {
                minCnt = Math.min(minCnt, drugCnt);
            }
            return;
        }

        drugs[idx] = drug;

        dfs(2, idx + 1, drugCnt);
        dfs(0, idx + 1, drugCnt + 1);
        dfs(1, idx + 1, drugCnt + 1);
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

    // 약품 바른 카피본 리턴해주는 함수
    private static int[][] copy() {
        int[][] copy = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 약품 안바르기
                if (drugs[i] == 2) {
                    copy[i][j] = film[i][j];
                } else {    // 약품 바르기
                    copy[i][j] = drugs[i];
                }
            }
        }

        return copy;
    }



    private static void printDoubleArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(film[i][j] + " ");
            }
            System.out.println();
        }
    }

}
