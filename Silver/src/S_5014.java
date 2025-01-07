import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5014 {
    private static int totalFloor, campFloor, canUp, canDown;
    private static int[] visited, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalFloor = Integer.parseInt(st.nextToken());
        int curFloor = Integer.parseInt(st.nextToken());
        campFloor = Integer.parseInt(st.nextToken());
        canUp = Integer.parseInt(st.nextToken());
        canDown = Integer.parseInt(st.nextToken());

        d = new int[]{canUp, -canDown};

        visited = new int[totalFloor + 1];

        if (curFloor == campFloor) {
            System.out.println(0);
            return;
        }

        System.out.println(move(curFloor));

    }

    private static String move(int cur) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = 1;

        while (!q.isEmpty()) {
            int curFloor = q.poll();

            if (curFloor == campFloor) {
                return String.valueOf(visited[curFloor] - 1);
            }

            for (int i = 0; i < d.length; i++) {
                int next = curFloor + d[i];
                if (next > 0 && next <= totalFloor && visited[next] == 0) {
                    visited[next] = visited[curFloor] + 1;
                    q.add(next);
                }
            }
        }

        return "use the stairs";
    }
}
