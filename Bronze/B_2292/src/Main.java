// 백준 2292 : 벌집
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 1;

        int sum = 1;

        while (N > sum) {

            sum = (i * 6) + sum;
            i++;
        }

        System.out.println(i);
    }
}