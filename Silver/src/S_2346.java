import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_2346 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        int cursor = 0;
        while (!list.isEmpty()) {
            int[] cur = list.get(cursor);
            int idx = cur[0];
            int val = cur[1];

            sb.append(idx).append(" ");
            list.remove(cursor); // 현재 풍선 제거

            if (list.isEmpty()) {
                break;
            }

            if (val > 0) {
                cursor = (cursor + (val - 1)) % list.size();
            } else {
                cursor = (cursor + val) % list.size();
                if (cursor < 0) {
                    cursor += list.size();
                }
            }
        }

        System.out.println(sb);
    }
}
