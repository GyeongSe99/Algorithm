package S_3273;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        if (N <= 1) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int front = 0;
        int back = N - 1;
        int cnt = 0;

        while (front < back) {
            int sum = arr[front] + arr[back];

            if (sum < X) {
                front++;
            } else if (sum == X) {
                front++;
                cnt++;
            } else {
                back--;
            }
        }

        System.out.println(cnt);
    }
}
