package B_17206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int num : test) {
            int last3 = num / 3;
            int last7 = num / 7;
            int last21 = num / 21;
            int sum = (3 * last3 * (last3 + 1) / 2) + (7 * last7 * (last7 + 1) / 2) - (21 * last21 * (last21 + 1) / 2);



            System.out.println(sum);
        }

    }
}
