import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        int cap = 4;
//        int n = 5;
//        int[] deliveries = {1, 0, 3, 1, 2};
//        int[] pickups = {0, 3, 0, 4, 0};

        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        long answer = solution(cap, n, deliveries, pickups);

        System.out.println(answer);
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> deli = new Stack<>();
        Stack<Integer> pick = new Stack<>();

        long distance = 0;

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deli.push(i);
            }
            if (pickups[i] != 0) {
                pick.push(i);
            }
        }

        while (!deli.isEmpty() || !pick.isEmpty()) {
            int nowCap = cap;
            int maxDistance = Integer.MIN_VALUE;

            while (!deli.isEmpty() && nowCap > 0) {
                int deliIdx = deli.pop();
                // 스택에 들어가 있는 값은 인덱스이므로 1증가 시키기
                maxDistance = Math.max(maxDistance, deliIdx + 1);
                int deliCnt = deliveries[deliIdx];

                if (deliCnt > nowCap) {
                    deliveries[deliIdx] = deliCnt - nowCap;
                    deli.push(deliIdx);
                    nowCap = 0;
                } else if (deliCnt == nowCap) {
                    deliveries[deliIdx] = 0;
                    nowCap = 0;
                } else {
                    deliveries[deliIdx] = 0;
                    nowCap = nowCap - deliCnt;
                }
            }

            nowCap = cap;

            while (!pick.isEmpty() && nowCap > 0) {
                int pickIdx = pick.pop();
                // 스택에 들어가 있는 값은 인덱스이므로 1증가 시키기
                maxDistance = Math.max(maxDistance, pickIdx + 1);
                int pickCnt = pickups[pickIdx];

                if (pickCnt > nowCap) {
                    pickups[pickIdx] = pickCnt - nowCap;
                    pick.push(pickIdx);
                    nowCap = 0;
                } else if (pickCnt == nowCap) {
                    pickups[pickIdx] = 0;
                    nowCap = 0;
                } else {
                    pickups[pickIdx] = 0;
                    nowCap = nowCap - pickCnt;
                }
            }

            distance += maxDistance * 2;

        }

        System.out.println(distance);

        return distance;
    }



}