package B_3040;

// 백준 2851 : 슈퍼마리오

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int k : arr) {
            sum += k;
        }

        int aIdx = -1;
        int bIdx = -1;

        // 무조건 9개 줄
        out : for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    aIdx = i;
                    bIdx = j;
                    break out;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == aIdx || i == bIdx) {
                continue;
            }
            System.out.println(arr[i]);
        }



    }
}
