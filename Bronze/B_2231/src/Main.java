// 백준 2231 : 분해합

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;

        for (int i = 1; i < n; i++) {
            int temp = i + sum(i);
            if (temp == n) {
                num = i;
                break;
            }
        }
        System.out.println(num);
    }

    private static int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += (i % 10);
            i /= 10;
        }
        return sum;
    }
}