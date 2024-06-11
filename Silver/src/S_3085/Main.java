package S_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int tc;
    private static char[][] candies;
    private static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    public static void main(String[] args) throws Exception {

        tc = Integer.parseInt(br.readLine());
        candies = new char[tc][tc];

        getCandies();

        for (int r = 0; r < tc; r++) {
            for (int c = 0; c < tc; c++) {
                // 현재 위치
                char now = candies[r][c];

                for (int i = 0; i < 4; i++) {
                    // 비교할 위치
                    int nr = r + d[i][0];
                    int nc = c + d[i][1];

                    // 범위 안에 있을때
                    if (nr >= 0 && nc >= 0 && nr < tc && nc < tc) {
                        // 현재사탕와 비교했을 때 다르다면
                        char side = candies[nr][nc];
                        if (now != side) {
                            // 자리를 바꾼 후
                            candies[r][c] = side;
                            candies[nr][nc] = now;

                            // 연속된 사탕의 수 세기
                            answer = Math.max(answer, count());

                            // 원래 자리로 복구
                            candies[r][c] = now;
                            candies[nr][nc] = side;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void getCandies() throws IOException {
        for (int i = 0; i < tc; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < tc; j++) {
                candies[i][j] = cArr[j];
            }
        }
    }

    private static int count() {
        int maxCount = 0;

        // 행을 검사
        for (int i = 0; i < tc; i++) {
            int count = 1;
            for (int j = 1; j < tc; j++) {
                if (candies[i][j] == candies[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        // 열을 검사
        for (int j = 0; j < tc; j++) {
            int count = 1;
            for (int i = 1; i < tc; i++) {
                if (candies[i][j] == candies[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
