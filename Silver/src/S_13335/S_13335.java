package S_13335;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_13335 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int sumWeight = 0;

        while (!trucks.isEmpty()) {
            int truck = trucks.peek();

            if (bridge.size() == w) {
                sumWeight -= bridge.poll();
            }

            // 무게 기록용
            if (sumWeight + truck <= L) {
                sumWeight += truck;
                bridge.add(trucks.poll());
            } else {
                bridge.add(0);
            }

            time++;
        }

        System.out.println(time + w);
    }

}
