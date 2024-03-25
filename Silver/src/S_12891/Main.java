package S_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 12891 : DNA 비밀번호
public class Main {
    static int[] agct;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String dna = br.readLine();

        // 남은 A, C, G, T 개수
        agct = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        int left = 0;
        int right = arr[1];

        for (int i = 0; i < right; i++) {
            char c = dna.charAt(i);
            int idx = foundIndex(c);
            agct[idx]--;
        }

        if (isPassword()) cnt++;

        while (right < dna.length()) {

            char leftChar = dna.charAt(left);
            agct[foundIndex(leftChar)]++;
            left++;
            char rightChar = dna.charAt(right);
            agct[foundIndex(rightChar)]--;
            right++;

            if (isPassword()) cnt++;
        }

        System.out.println(cnt);

    }

    public static int foundIndex(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean isPassword() {
        for (int j : agct) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
}