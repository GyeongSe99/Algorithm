package cheeseThief;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] cheese, copy;
    static List<Integer> days;  // 최댓값 최솟값
    static int maxMass, N, T;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            cheese = new int[N][N];
            maxMass = 1;
            days = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    cheese[j][k] = Integer.parseInt(st.nextToken());
                    if (!days.contains(cheese[j][k])) {
                        days.add(cheese[j][k]);
                    }
                }
            }

            // 정렬한 후 날짜 순으로 보기
            Collections.sort(days);

            for (int i = 0; i < days.size(); i++) {
                int cur = days.get(i);

                // 먹기
                eat(cur);

                // 먹고 난 후 치즈 덩어리 개수 카운트
                maxMass = Math.max(countCheeseMass(), maxMass);
            }

            System.out.println("#" + test_case + " " + maxMass);

        }
    }

    static void eat(int day) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] <= day) {
                    cheese[i][j] = 0;
                }
            }
        }
    }

    static int countCheeseMass() {
        copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(cheese[i], N);
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copy[i][j] != 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int r, int c) {
        copy[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && copy[nr][nc] != 0) {
                dfs(nr, nc);
            }
        }
    }


    static void print(int[][] arr) {
        System.out.println("----------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
