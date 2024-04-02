package changyongVil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 창용 마을에 사는 사람 수
            int M = Integer.parseInt(st.nextToken());   // 서로 알고있는 관계의 수

            p = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                p[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> result = new HashSet<>();

            for (int i = 0; i < N + 1; i++) {
                p[i] = findset(i);
            }

            for (int i = 1; i < N + 1; i++) {
                result.add(p[i]);
            }

            System.out.println("#" + test_case + " " + result.size());
        }
    }

    // 최고 조상 찾는 메소드
    private static int findset(int n) {
        if (p[n] == n) {
            return n;
        }
        return findset(p[n]);
    }

    public static void union(int a, int b) {
        int pa = findset(a);
        int pb = findset(b);

        if (pa == pb) return;

        if (pa <= pb) p[pb] = pa;
        else p[pa] = pb;
    }
}
