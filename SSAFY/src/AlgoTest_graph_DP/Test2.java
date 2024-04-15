package AlgoTest_graph_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 보호소의 위치를 모두 갱신
            Queue<int[]> restZone = new LinkedList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                restZone.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            int[][][] minMap = new int[N][N][2];
            minMap[0][0][0] = map[0][0];


            // minMap[][][0] = 출발지점에서 해당 지점까지 가는 최소 위험성 기록
            // 나중에 minMap[][][1]부분에 해당 지점(쉼터)에서부터 도착지점까지의 최소위험성을 다시 기록.
            // 쉼터 -> 집까지의 최소 위험성을 갱신하기 위해 minMap[][][0]과 map[][]이 필요하므로 minaMap[][][1]을 따로 만들어 이 곳에 갱신하는 것.
            for (int i = 1; i < N; i++) {
                minMap[0][i][0] = minMap[0][i - 1][0] + map[0][i];
                minMap[i][0][0] = minMap[i - 1][0][0] + map[i][0];
            }


            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    minMap[i][j][0] = Math.min(minMap[i - 1][j][0], minMap[i][j - 1][0]) + map[i][j];
                }
            }

            int minVal = Integer.MAX_VALUE;

            // 쉼터에서 집까지의 최단거리 & 최소 위험성 갱신
            roop : while(!restZone.isEmpty()) {
                int[] curRest = restZone.poll();

                int r = curRest[0];
                int c = curRest[1];

                int danger = minMap[r][c][0];

                minMap[r][c][1] = danger;

                // 세로 갱신
                for (int i = r + 1; i < N; i++) {
                    minMap[i][c][1] = minMap[i - 1][c][1] + map[i][c];
                }

                // 가로 갱신
                for (int i = c + 1; i < N; i++) {
                    minMap[r][i][1] = minMap[r][i - 1][1] + map[r][i];
                }

                // 도착지점까지 갱신
                for (int i = r + 1; i < N; i++) {
                    for (int j = c + 1; j < N; j++) {
                        minMap[i][j][1] = Math.min(minMap[i-1][j][1], minMap[i][j - 1][1]) + map[i][j];
                        if (minMap[i][j][1] > minVal) continue roop;
                    }
                }

                // 도착지점까지의 최소 위험성
                int result = minMap[N-1][N-1][1];

                if(result < minVal) {
                    minVal = result;
                }
            }

            System.out.println("#" + test_case + " " + minVal);

        }


    }
}
