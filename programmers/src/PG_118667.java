public class PG_118667 {
    private static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int n = queue1.length;
            long sum1 = 0, sum2 = 0, total;

            int[] queue = new int[n * 2];
            for (int i = 0; i < n; i++) {
                queue[i] = queue1[i];
                sum1 += queue1[i];
                queue[n + i] = queue2[i];
                sum2 += queue2[i];
            }

            total = sum1 + sum2;
            if (total % 2 != 0) return -1;

            long target = total / 2;
            int left = 0, right = n;
            int cnt = 0;    // 탐색 횟수

            while (left < n * 2 && right < n * 2) {
                if (sum1 == target) return cnt;

                if (sum1 < target) {
                     sum2 -= queue[right];
                     sum1 += queue[right];
                     right++;
                } else {
                    sum1 -= queue[left];
                    sum2 += queue[left];
                    left++;
                }

                cnt++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
//        System.out.println(result);
//        result = solution.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
//        System.out.println(result);
        int result3 = solution.solution(new int[]{1,1}, new int[]{1, 5});
        System.out.println(result3);
    }
}
