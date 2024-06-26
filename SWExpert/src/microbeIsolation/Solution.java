package microbeIsolation;
// 미생물 분리

// 보드의 맨 끝은 약품처리가 되어있다.
// 살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Micro {
        int r, c, d, capacity;

        public Micro(int r, int c, int d, int capacity) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.capacity = capacity;
        }

        public Micro(Micro micro) {
            this(micro.r, micro.c, micro.d, micro.capacity);
        }

        @Override
        public String toString() {
            return "Micro{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    private static final int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<Micro> micros;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            micros = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cap = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                Micro newMicro = new Micro(r, c, d, cap);
                micros.add(newMicro);
            }

            for (int i = 0; i < m; i++) {
                move();
                merge();
            }

            int sum = 0;
            for (Micro micro : micros) {
                sum += micro.capacity;
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }

    // 이동하는 메소드
    private static void move() {
        for (Micro micro : micros) {
            micro.r = micro.r + d[micro.d][0];
            micro.c = micro.c + d[micro.d][1];

            if (checkIsBorder(micro)) {
                micro.capacity = micro.capacity / 2;
                if (micro.capacity != 0) {
                    micro.d = changeDirection(micro.d);
                }
            }
        }

        micros.removeIf(micro -> micro.capacity == 0);
    }

    // 같은 자리 겹치는 애들 합치는 메소드
    private static void merge() {
        List<Micro> copy = new ArrayList<>();
        for (Micro micro : micros) {
            copy.add(new Micro(micro));
        }

        int cur = 0;

        while (cur < copy.size()) {
            if (copy.size() <= 1) {
                break;
            }
            Micro curMic = copy.get(cur);

            int maxIdx = cur;   // 제일 큰 애의 위치
            int maxCap = curMic.capacity;
            int sum = curMic.capacity;
            int size = copy.size();

            for (int i = cur + 1; i < size; i++) {
                Micro m = copy.get(i);
                // 같은 위치에 있으면
                if (curMic.r == m.r && curMic.c == m.c) {
                    // 일단 값 합쳐주고
                    sum += m.capacity;
                    // 값이 더 크면 갱신
                    if (maxCap < m.capacity) {
                        maxCap = m.capacity;
                        maxIdx = i;
                    }
                    m.capacity = 0;
                }
            }

            curMic.d = copy.get(maxIdx).d;
            curMic.capacity = sum;
            cur++;
        }

        copy.removeIf(micro -> micro.capacity == 0);
        micros = copy;
    }

    // 끝자락에 있는지 확인하기
    private static boolean checkIsBorder(Micro micro) {
        return micro.r == 0 || micro.c == 0 || micro.r == N - 1 || micro.c == N - 1;
    }

    // 방향 바꿔주기
    private static int changeDirection(int dir) {
        switch (dir) {
            case 0: // 상
                return 1; // 하
            case 1: // 하
                return 0; // 상
            case 2: // 좌
                return 3; // 우
            case 3: // 우
                return 2; // 좌
            default:
                return -1;
        }
    }
}
