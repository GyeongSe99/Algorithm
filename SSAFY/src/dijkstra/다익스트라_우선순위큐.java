package dijkstra;

import java.util.*;

public class 다익스트라_우선순위큐 {
    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Node>[] adjList;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        dist = new int[V];
        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            // 시작정점 도착정점 가중치 순으로 입력이 되므로 아래처럼 작성할 수 있다.
            adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }

        dijkstra(0);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V]; // 방문처리
        dist[start] = 0;    // 시작 노드까지의 거리는 0으로 초기화

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.v]) continue;  // 이미 방문했다면 비용을 알고 있다는 뜻
            visited[curr.v] = true; // 선택

            for (Node node : adjList[curr.v]) {
                if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
                    dist[node.v] = dist[curr.v + node.w];
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }


    }


}
