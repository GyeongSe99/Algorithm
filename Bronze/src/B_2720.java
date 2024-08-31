import java.io.BufferedReader;
import java.io.InputStreamReader;

// 25, 10, 5, 1

public class B_2720 {

    private static final int[] coins = {25, 10, 5, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int change = Integer.parseInt(br.readLine());

            for (int coin : coins) {
                sb.append(change/coin).append(" ");
                change %= coin;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
