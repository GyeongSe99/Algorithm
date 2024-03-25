package B_1037;
// https://www.acmicpc.net/problem/1037

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        long answer;

        if (arr.length % 2 == 0) {
            answer = (long) arr[N / 2 - 1] * arr[N / 2];
        } else {
            answer = (long) arr[N / 2] * arr[N / 2];
        }

        System.out.println(answer);

    }
}
