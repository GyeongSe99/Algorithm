package G_2096;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] minDP = new int[3];
        int[] maxDP = new int[3];

        int[] d = {-1, 0, 1};

        // 높이
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    int x = Integer.parseInt(st.nextToken());

                    minDP[j] = x;
                    maxDP[j] = x;
                }
                continue;
            }

            int[] now = new int[3];

            for (int j = 0; j < 3; j++) {
                now[j] = Integer.parseInt(st.nextToken());
            }

            int[] nextMin = new int[3];
            int[] nextMax = new int[3];

            // 길이
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < d.length; k++) {
                    int prevIdx = j + d[k];

                    if (prevIdx >= 0 && prevIdx < 3) {
                        min = Math.min(minDP[prevIdx], min);
                        max = Math.max(maxDP[prevIdx], max);
                        nextMin[j] = now[j] + min;
                        nextMax[j] = now[j] + max;
                    }
                }
            }

            minDP = nextMin;
            maxDP = nextMax;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minDP[i]);
            max = Math.max(max, maxDP[i]);
        }

        System.out.println(max + " " + min);



    }
}
