package S_2304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int[] arr = new int[1001];
    static ArrayList<Integer> indexList = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxIdx = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            indexList.add(idx);
            arr[idx] = val;
            if (max < val) {
                max = val;
                maxIdx = idx;
            }
        }

        Collections.sort(indexList);

        for (int i = 0; i < indexList.size() && indexList.get(i) < maxIdx; i++) {
            int idx = indexList.get(i);
            if (stack.isEmpty()) {
                stack.push(idx);
            }

            if (arr[stack.peek()] < arr[idx]) {
                stack.push(idx);
            }
        }

        int sumArea = 0;

        sumArea += getAreaNum(maxIdx);

        for (int i = indexList.size() - 1; maxIdx < indexList.get(i) && i >= 0; i--) {
            int idx = indexList.get(i);
            if (stack.isEmpty()) {
                stack.push(idx);
            }

            if (arr[stack.peek()] < arr[idx]) {
                stack.push(idx);
            }
        }

        sumArea += getAreaNum(maxIdx);
        sumArea += max;

        System.out.println(sumArea);

    }

    static int getAreaNum(int prevIdx) {
        int sum = 0;

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int height = arr[idx];
            int length = Math.abs(prevIdx - idx);

            sum += height * length;

            prevIdx = idx;
        }

        return sum;
    }
}
