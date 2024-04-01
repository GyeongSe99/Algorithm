package prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림_우선순위큐 {
    static final int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {
        int st, ed, w;

        public Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        // 인접리스트
        List<Edge>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();   // 시작 정점
            int B = sc.nextInt();   // 도착 정점
            int W = sc.nextInt();   // 가중치

            adjList[A].add(new Edge(A, B, W));
            adjList[B].add(new Edge(B, A, W));
        }

        // 방문 처리
        boolean[] visited = new boolean[V];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        visited[0] = true;  // 0번 정점에서 시작

        // 0번 정점과 인접한 정점 pq에 전부 넣기
        for (int i = 0; i < adjList[0].size(); i++) {
            pq.add(adjList[0].get(i));
        }
//        pq.addAll(adjList[0]);

//        for (Edge e : adjList[0]) {
//            pq.add(e);
//        }

        int pick = 1;   // 현재 확보한 정점의 개수
        int ans = 0;    // 비용 : 0

        // pick이 V가 되면 멈추기
        while (pick != V) {
            Edge e = pq.poll(); // 처음에는 2번 정점 뽑기
            // 2번 정점은 ed에 들어있음 st(0) -> ed

            // 이미 해당 정점이 방문한 점이라면
            if (visited[e.ed]) continue;

            // 방문한적 없다면
            ans += e.w;
            visited[e.ed] = true;
            pick++;

            //반복문을 돌면서 갱신할 수 있는것들을 전부 갱신
            pq.addAll(adjList[e.ed]);
        }




    }
}
