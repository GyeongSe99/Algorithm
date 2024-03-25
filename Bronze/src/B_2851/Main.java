package B_2851;

// 백준 2851 : 슈퍼마리오

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int targetScore = 100;
    static int T = 10;
    static int answer = -1;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (answer < targetScore) {
                sum += n;
                checkMinDist(sum);
            } else {
                break;
            }
        }

        System.out.println(answer);

    }

    public static void checkMinDist(int sum) {
        int dist = Math.abs(targetScore - sum);
        if (minDist == dist && answer < sum) {
            answer = sum;
        } else if (minDist > dist){
            answer = sum;
            minDist = dist;
        }
    }
}