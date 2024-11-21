// 쭉 더한거보다 현재 값이 크면 쭉 더한거를 버리고 현재값부터 다시 더하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import sun.font.CreatedFontTracker;

public class S_1912 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int result = 0;
        for (int i = 0; i < N; i++) {
            int n = arr[i];
            if (n > result + n) {
                result = n;
            } else {
                result += n;
            }

            max = Math.max(max, result);
        }

        System.out.println(max);

    }

//    private static void printArr(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }

}
