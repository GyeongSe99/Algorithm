package contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    static int max, lastDepth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            max = -1;
            lastDepth = 0;

            map = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    int from = Integer.parseInt(st.nextToken());
                    List<Integer> list = map.getOrDefault(from, new ArrayList<>());
                    list.add(Integer.parseInt(st.nextToken()));
                    map.put(from, list);
                }
            }

            visited[start] = true;
            bfs(start);

            System.out.println("#" + test_case + " " + max);

        }

    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (lastDepth <= cur[1]) {
                if (lastDepth < cur[1]) {
                    lastDepth = cur[1];
                    max = cur[0];
                } else {
                    max = Math.max(max, cur[0]);
                }
            }

            List<Integer> list = map.getOrDefault(cur[0], new ArrayList<>());

            for (int next : list) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }
}
