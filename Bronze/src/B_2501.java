import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2501 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int idx = 0;
        int num = 0;

        for (int i = 1; i <= input[0]; i++) {
            if (input[0] % i == 0) {
                idx++;
                num = i;
                if (idx == input[1]) break;
            }
        }

        if (idx < input[1]) {
            System.out.println(0);
        } else {
            System.out.println(num);
        }
    }

}
