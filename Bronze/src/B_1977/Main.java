package B_1977;
// https://www.acmicpc.net/problem/1977
// 완전제곱수

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int i = 1;
        int sqrt = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (sqrt <= N) {
            sqrt = i * i;
            if (sqrt >= M && sqrt <= N) {
                sum += sqrt;
                min = Math.min(sqrt, min);
                if (sqrt > N) break;
            }
            i++;
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + " " + min);
        }
    }
}
