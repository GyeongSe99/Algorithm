package workOrder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<List<Integer>> board;
    static int[] countArr;
    static boolean[] visited;
    static int V, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            countArr = new int[V + 1];
            visited = new boolean[V + 1];

            board = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                board.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < E; i++) {
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                // 자식으로 불릴때마다 cnt 올려주기
                countArr[v2]++;

                board.get(v1).add(v2);
            }

            StringBuilder sb = new StringBuilder();

            while (true) {
                boolean visit = false;
                List<Integer> temp = new ArrayList<>();

                for (int i = 1; i < board.size(); i++) {

                    // 한번도 자식으로 불린 적 없음
                    if (countArr[i] <= 0 && !visited[i]) {
                        sb.append(i).append(" ");
                        visited[i] = true;
                        visit = true;
                        temp.add(i);
                    }
                }

                // 현재 보고있는 부모의 간선 정보를 쭉 돌면서 count 줄여주기
                for (int i = 0; i < temp.size(); i++) {
                    List<Integer> cur = board.get(temp.get(i));

                    for (int j = 0; j < cur.size(); j++) {
                        countArr[cur.get(j)]--;
                    }
                }

                if (!visit) break;
            }


            System.out.println("#" + test_case + " " + sb);

        }

    }
    static void print() {
        for (int i = 0; i <= V; i++) {
            List<Integer> cur = board.get(i);
            System.out.println("idx = " + i );

            for (int j = 0; j < cur.size(); j++) {
                System.out.print(cur.get(j));
            }
            System.out.println();
        }
    }
}
