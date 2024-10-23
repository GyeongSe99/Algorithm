package S_1966;

// 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
// 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1966 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int targetIdx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[][] arr = new int[N][2];

            if (N == 1) {
                sb.append(1).append("\n");
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                boolean isNotMax = false;

                for (int[] ar : queue) {
                    if (ar[1] > cur[1]){ // 현재보다 큰게 있으면
                        queue.add(cur);
                        isNotMax = true;
                        break;
                    }
                }

                if (!isNotMax) { // 출력해야되는 타이밍일 때
                    cnt++;
                    if (cur[0] == targetIdx) {
                        sb.append(cnt).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
