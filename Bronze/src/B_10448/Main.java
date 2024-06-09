package B_10448;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] triNum = new int[47];
        for (int i = 1; i <= 46; i++) {
            triNum[i] = i*(i+1)/2;
        }

        out: for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            for (int j = 1; j <= 46; j++) {
                for (int k = 1; k <= 46; k++) {
                    for (int l = 1; l <= 46; l++) {
                        int sum = triNum[j] + triNum[k] + triNum[l];
                        if (sum == num) {
                            System.out.println(1);
                            continue out;
                        }
                    }
                }
            }

            System.out.println(0);
        }
    }
}