package S_2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());   // 가로
        int n = Integer.parseInt(st.nextToken());   // 세로
        int k = Integer.parseInt(br.readLine());    // 상점의 개수

        int[] shops = new int[k];
        // dist : 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리
        // dist : 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int side = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shops[i] = calcDist(side, dist, m, n);
        }

        // 일직선상에서 봤을 때 동근이의 위치
        st = new StringTokenizer(br.readLine());
        int dongSide = Integer.parseInt(st.nextToken());
        int dongDist = Integer.parseInt(st.nextToken());
        int dongPos = calcDist(dongSide, dongDist, m, n);

        int total = 0;
        int fullSize = 2 * (m + n);
        for (int shopPos : shops) {
            int num = Math.abs(shopPos - dongPos);
            total += Math.min(num, fullSize - num);
        }

        System.out.println(total);

    }

    // 왼쪽 맨위를 기준으로 얼마나 떨어져있나 일직선 상에 놓고 보기
    // 1: 북, 2: 남, 3: 서, 4: 동
    private static int calcDist(int side, int dist, int m, int n) {
        switch (side) {
            case 1: return dist;
            case 4: return m + dist;
            case 2: return m + n + (m - dist);
            case 3: return 2*m + n + (n - dist);
            default: return 0;
        }
    }
}
