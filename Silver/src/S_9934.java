import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_9934 {

    private static int[] arr;
    private static ArrayList[] levels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[(int) Math.pow(2, K) - 1];
        levels = new ArrayList[K + 1];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, arr.length, 0);

        for (int i = 0; i < levels.length; i++) {
            for (int j = 0; j < levels[i].size(); j++) {
                sb.append(levels[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void find(int start, int end, int depth) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        levels[depth].add(arr[mid]);

        find(start, mid, depth + 1);
        find(mid + 1, end, depth + 1);
    }

}
