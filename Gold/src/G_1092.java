import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class G_1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 크레인의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
            return;
        }

        int day = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0, craneIdx = 0;

            while (craneIdx < cranes.size()) {
                if (boxIdx >= boxes.size()) break;

                if (cranes.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            day++;
        }

        System.out.println(day);
    }
}
