package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라_반복문 {
    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
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
//            int A = sc.nextInt();
//            int B = sc.nextInt();
//            int W = sc.nextInt();

            // 시작정점 도착정점 가중치 순으로 입력이 되므로 아래처럼 작성할 수 있다.
            adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }

        dijkstra(0);

    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[V]; // 방문처리

        dist[start] = 0;    // 시작 노드까지의 거리는 0으로 초기화

        // 모든 정점을 다 돌때까지 (문제를 보고 도착 정점이 주어졌을 때, 거기 방문하면 멈추도록 해도 됨)
        for (int i = 0; i < V-1; i++) {
            int min = INF;
            int idx = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }   // idx : 방문하지 않았으면서, 시작 정점으로 부터 해당 idx 정점까지의 거리가 최소인 정점 pick

            // 다 돌아봤는데 갈 곳이 없다면
            if (idx == -1) break;

            visited[idx] = true;

            // pick한 정점과 인접한 정점들을 쭉 돌아봤을때 방문하지 않았으면서
            // (이전에 기록됐었던 최소 거리)가 ( idx의 최소거리 + 가중치) 보다 크다면 더 작은 값으로 새로 갱신
            // (idx에서부터 해당 정점까지 가는데 드는 비용 + 해당 정점의 가중치)
            for (Node node : adjList[idx]) {
                if (!visited[node.v] && dist[node.v] > dist[idx] + node.w) {
                    dist[node.v] = dist[idx] + node.w;
                }
            }
        }
    }


}
