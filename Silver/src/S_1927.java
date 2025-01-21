import java.util.PriorityQueue;
import java.util.Scanner;

public class S_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();

            if (n == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else {
                pq.add(n);
            }
        }

        System.out.println(sb);

    }
}
