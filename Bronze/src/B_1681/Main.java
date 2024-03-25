package B_1681;
// https://www.acmicpc.net/problem/1681
// 줄세우기

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int num = 1;

        for (int i = 0; i < N; i++) {
            String numStr = String.valueOf(num);

            boolean isValid = true;

            for (int j = 0; j < numStr.length(); j++) {
                if (Character.getNumericValue(numStr.charAt(j)) == L) {
                    isValid = false;
                    break;
                }
            }
            num++;

            if (!isValid) {
                i--;
            }

        }

        System.out.println(num - 1);
    }
}