import java.util.Scanner;

public class S_2885 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int size = 1;
        while (size < K) {
            size *= 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");

        int cnt = 0;

        int need = K;
        while (need > 0) {

            if (size <= need) {
                need -= size;
            } else {
                size /= 2;
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}
