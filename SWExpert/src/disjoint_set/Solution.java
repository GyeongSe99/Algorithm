package disjoint_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            p = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                p[i] = i;
            }

            // 연산 시작
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 같으면 skip
                if (a == b) {
                    if (command == 1) {
                        sb.append(1);
                    }
                    continue;
                }

                int pa = findset(a);
                int pb = findset(b);

                // 연산 시작
                // 같은 집합인지 확인
                if (command == 1) {
                    if (pa == pb) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                } else { // 합치기
                    union(pa, pb);
                }
            }

            System.out.println("#" + test_case + " " + sb);
        }
    }

    public static int findset(int x) {
        if (p[x] == x) {
            return x;
        }
        int parent = findset(p[x]);
        p[x] = parent;
        return parent;
    }

    public static void union(int pa, int pb) {
        if (pa == pb) {
            return;
        }

        if (pa <= pb) p[pb] = pa;
        else p[pa] = pb;
    }
}
