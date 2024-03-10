package Lv2_92342;

import java.util.Arrays;

public class Main {
    static int[] apeach, ryan, result;
    static int maxScore;
    static boolean isChanged;

    public static void dfs(int cnt, int N, int start) {
        if (cnt == N) {
            int aScore = 0;
            int rScore = 0;

            for (int i = 0; i < apeach.length; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) continue;
                int score = 10 - i;

                if (apeach[i] >= ryan[i]) {
                    aScore += score;
                } else {
                    rScore += score;
                }
            }

            if (rScore > aScore) {
                int scoreDiff = rScore - aScore;
                if (maxScore < scoreDiff) {
                    maxScore = scoreDiff;
                    isChanged = true;
                    result = ryan.clone();
                } else if (maxScore == scoreDiff) {
                    for (int i = apeach.length - 1; i >= 0; i--) {
                        if (ryan[i] > result[i]) {
                            isChanged = true;
                            result = ryan.clone();
                            return;
                        } else if (result[i] > ryan[i]) {
                            return;
                        }
                    }
                }
            }

            return;
        }

        for (int i = start; i < apeach.length; i++) {
            if (apeach[i] >= ryan[i]) {
                ryan[i]++;
                dfs(cnt + 1, N, i);
                ryan[i]--;
            }
        }
    }


    public int[] solution(int n, int[] info) {
        apeach = info;
        ryan = new int[info.length];
        maxScore = Integer.MIN_VALUE;
        result = new int[info.length];

        dfs(0, n, 0);

        if (!isChanged) {
            return new int[]{-1};
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        Main sol = new Main();
        sol.solution(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1});
    }
}
