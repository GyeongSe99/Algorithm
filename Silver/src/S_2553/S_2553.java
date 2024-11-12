package S_2553;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_2553 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = 1;
        long result2 = 1;

        for (int i = 1; i <= N; i++) {
            result *= i;
            result2 *= i;
            System.out.println();
            System.out.println("i" + i);

            while (result % 10 == 0) {
                result /= 10;
            }

            while (result2 % 10 == 0) {
                result2 /= 10;
            }

            result %= 10000000;
            result2 %= 100;

            System.out.println(result);
            System.out.println(result2);
        }

        System.out.println(result % 10);
    }

}
