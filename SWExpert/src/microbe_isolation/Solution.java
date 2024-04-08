package microbe_isolation;
// 미생물 분리

// 보드의 맨 끝은 약품처리가 되어있다.
// 살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static class Micro {
        int r, c, d, capacity;

        public Micro(int r, int c, int d, int capacity) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.capacity = capacity;
        }
    }

    private static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<Micro> micros;
    private static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cap = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                Micro newMicro = new Micro(r, c, d, cap);
                micros.add(newMicro);
            }

            for (int i = 0; i < M; i++) {
                move();
                merge();
            }
        }
    }

    // 이동하는 메소드
    private static void move() {

    }

    // 같은 자리 겹치는 애들 합치는 메소드
    private static void merge() {

    }

    // 끝자락에 있는지 확인하기
    private static boolean checkIsBorder(Micro micro) {
        return false;
    }

    // 방향 바꿔주기
    private static void changeDirection(Micro micro) {

    }
}
