package B_11068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            String num = br.readLine();
            ArrayList<Integer> numList;
            boolean isTrue = false;

            for (int i = 2; i <= 64; i++) {
                numList = getNum(num, i);
                if (isPalindrome(numList)) {
                    isTrue = true;
                    break;
                }
            }

            sb.append(isTrue ? 1 : 0).append("\n");
            n--;
        }

        System.out.println(sb);
    }

    private static ArrayList<Integer> getNum(String num, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int N = Integer.parseInt(num);

        // 진법 변환 해서 List에 결과 저장
        while (N > 0) {
            int n = N % B;
            N /= B;
            result.add(n);
        }

        return result;
    }

    private static boolean isPalindrome(ArrayList<Integer> numList) {
        int front = 0;
        int back = numList.size() - 1;

        while (front < back) {
            if (!numList.get(front).equals(numList.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
