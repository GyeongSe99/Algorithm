package topological_Sorting;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_Stack {
    public static String[] cook = {"", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음 만들기", "식사", "뒷정리", "채소손질", "밥하기"};
    static int V, E;
    static int[][] adj;
    static int[] degree;
    static boolean[] visited;
    static Stack<Integer> stack; // 할일을 담을 스택

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();

        adj = new int[V+1][V+1];
        degree = new int[V+1];
        visited = new boolean[V+1];
        stack = new Stack<>();

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            adj[A][B] = 1;  // 가중치가 따로 없기 때문에 1로 표기, 유향이니 반대는 처리X
            // 진입차수를 증가
            degree[B]++;
        }

        for (int i = 0; i < V+1; i++) {
            // 진입차수가 0인 정점들을 전부다 DFS
            if (degree[i] == 0) DFS(i);
        }

        // 해당 라인이 수행된다는 뜻은 위상정렬 끝
        // 해당 작업은 stack에 전부 들어있음
        while (!stack.isEmpty()) {
            System.out.print(cook[stack.pop()] + " -> ");
        }
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i = 1; i < V+1; i++) {
            // 인접하고, 방문하지 않은 점이 있다면 방문
            if (adj[v][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }

        // 해당 라인이 실행된다는 뜻은
        // 갈 수 있는 곳을 전부 갔다왔다는 뜻
        stack.add(v);
    }

    static String input = "9 9\r\n" +
            "1 4\r\n" +
            "1 8\r\n" +
            "2 3\r\n" +
            "4 3\r\n" +
            "8 5\r\n" +
            "3 5\r\n" +
            "5 6\r\n" +
            "9 6\r\n" +
            "6 7\r\n";
}
