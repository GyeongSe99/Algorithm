import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_1931 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            pq.add(temp);
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int time = cur[1];

            while (!pq.isEmpty() && pq.peek()[0] < time) {
                pq.poll();
            }
            ans++;
        }

        System.out.println(ans);
    }

}
