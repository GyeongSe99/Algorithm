package Kruskal;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] p; // 대표를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   // 정점의 개수(정점의 번호)
        int E = sc.nextInt();   // 간선의 개수

        // 간선의 배열을 이용
        // 1. 클래스를 직접 정의
        // 2. 2차원 배열을 이용하여 저장

        // [0]: 시작 정점, [1]: 끝 정점, [2]: 가중치
        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        // 가중치 기준으로 정렬
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);

        // V - 1 개의 간선 뽑기  (사이클이 발생하지 않도록 뽑기)
        p = new int[V];
        // 나 자신을 대표로 초기화
        for (int i = 0; i < V; i++) {
//            makeset(i);   -> 정석
            p[i] = i;
        }

        int ans = 0;    // 최소 비용의 합
        int pick = 0;   // 내가 뽑은 간선의 수

        // 간선 배열을 순회
        for (int i = 0; i < E; i++) {
            // i번째 간선을 뽑아 그 대표를 확인
            int px = findset(edges[i][0]);
            int py = findset(edges[i][1]);

            // x의 대표와 y의 대표가 다르면 연결해주기
            // 대표가 이미 같다면 연결이 되어있다는 의미이므로 간선 선택하지 않음. -> continue
            if (px != py) {
                union(px, py);
                ans += edges[i][2];
                pick++;
            }

            if (pick == V - 1) break;
        }

        System.out.println(ans);
    }

    private static int findset(int x) {
//        // 정석
//        if (x == p[x]) return x;
//        return findset(p[x]);

        // path compression 이용
        // 대표만 알면 되는 상황일 때,
        // 최고 조상으로 갱신해주는 방법 이용
        if (x != p[x]) {
            p[x] = findset(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y) {
//        // 정석
//        p[findset(y)] = findset(x);

        // 코드 변형으로 인해 어차피 넘어온 수는 대표인 상태이므로
        // (findset()을 이용하여 찾은 대표를 넘겨줌)
        p[y] = x;


    }

    static void makeset(int x) {
        p[x] = x;
    }
}