package prim;

import java.util.Arrays;
import java.util.Scanner;

public class 프림_반복문 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   // 0부터 시작
        int E = sc.nextInt();

        // 인접 행렬
        int[][] adjArr = new int[V][V];

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            // 무향 그래프
            adjArr[A][B] = adjArr[B][A] = W;
        }

        // 방문처리를 위해 visited 배열선언
        boolean[] visited = new boolean[V];
        int[] p = new int[V];   // 내가 어디서 왔는지
        int[] dist = new int[V];    // key라고 했던 가장 작은 비용을 저장하기 위한 배열

        // dist 초기화
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            p[i] = -1;  // 0으로 냅둬도 됨
        }

//        Arrays.fill(dist, INF);

        // 임의의 한점을 선택해서 돌리기
        dist[0] = 0;    // 0번 정점부터 돌겠다는 뜻
        int ans = 0;
        // 정점을 선택하는 사이클
        // 간선의 최소 개수만큼
        for (int i = 0; i < V; i++) {
            int min = INF;
            int idx = -1;

            // 아직 안뽑힌 정점들 중 가장 작은 값 뽑기.
            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }   // 해당 for문 종료시 idx : 가장 작은 값을 가지고 있고 방문하지 않은 정점이 선택됨.

            visited[idx] = true;    // 뽑음

            // 뽑은 친구와 인접한 정점들 중 갱신할 수 있으면 갱신
            for (int j = 0; j < V; j++) {
                // 방문하지 않았고 간선이 있으며(인접해 있으며), 최소 거리보다 해당 간선 사이의 거리가 더 작으면
                // 최소거리값 & 인덱스 갱신
                if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
                    dist[j] = adjArr[idx][j];
                    p[j] = idx;
                }
            }

        }

        for (int i = 0; i < V; i++) {
            ans += dist[i];
        }



    }
}
