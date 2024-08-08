package S_8979;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Comparator<int[]> myComparator = (o1, o2) -> {
            int compare = Integer.compare(o2[1], o1[1]);
            if (compare == 0) {
                compare = Integer.compare(o2[2], o1[2]);
                if (compare == 0) {
                    compare = Integer.compare(o2[3], o1[3]);
                }
            }
            return compare;
        };

        Arrays.sort(arr, myComparator);

        int rank = 1;
        int curRank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                int[] prev = arr[i - 1];
                int[] curr = arr[i];

                if (prev[1] == curr[1] && prev[2] == curr[2] && prev[3] == curr[3]) {
                }
                else curRank = i + 1;
            }
            rank = curRank;

            if (arr[i][0] == K) {
                break;
            }
        }

        System.out.println(rank);
    }
}
