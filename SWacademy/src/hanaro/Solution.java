package hanaro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int[][] islands;
    static double[][] edges;
    static double E;
    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());    // 섬의 개수

            // 0: x 좌표 1: y좌표
            islands = new int[N][2];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                islands[i][0] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                islands[i][1] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(st.nextToken());

            // 간선 정보 다 구해놓기
            // 0: 시작섬, 1: 도착섬, 2: 가중치
            int E = (N * (N - 1))/2;
            edges = new double[E][3];
            int idx = 0;
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    edges[idx++][2] = dist(i, j);
                }
            }

            // 크루스칼 사용
            // 1. 가중치 기준으로 오름차순 정렬
            Arrays.sort(edges, new Comparator<double[]>() {
                @Override
                public int compare(double[] o1, double[] o2) {
                    // 양수면
                    return (o1[2] - o2[2]) > 0 ? 1 : o1[2] - o2[2]== 0 ? 0 : -1;
                }
            });

            p = new int[E];

            for (int i = 0; i < E; i++) {
                p[i] = i;
            }

            // 엄마 찾기
            int ans = 0;    // 최소 비용
            int pick = 0;   // 내가 뽑은 간선의 수

            for (int i = 0; i < E; i++) {
                int px = findset((int)edges[i][0]);
                int py = findset((int)edges[i][1]);
            }
        }
    }

    // 최고 조상 찾기
    private static int findset(int x) {
        // 부모가 최고 조상이면 최고조상 리턴
        if (x == p[x]) {
            return x;
        } else {
            // 부모가 최고 조상이 아니면 다시 그 위의 엄마 보기
            return findset(p[x]);
        }
    }

    // 거리 계산
    private static double dist(int s, int e) {
        return (Math.pow(Math.abs(islands[s][0] - islands[e][0]), 2) + Math.pow(Math.abs(islands[s][1] - islands[e][1]), 2)) * E;
    }
}
