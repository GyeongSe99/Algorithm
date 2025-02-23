import java.util.PriorityQueue;

public class PG_12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int work : works) {
            pq.add(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int cur = pq.poll() - 1;
            if (cur >= 0) {
                pq.add(cur);
            }
            n--;
        }

        for (int num : pq) {
            answer += (long) num * num;
        }

        return answer;
    }

    public static void main(String[] args) {
        PG_12927 p = new PG_12927();
        System.out.println(p.solution(4, new int[]{4, 3, 3}));
        System.out.println(p.solution(1, new int[]{2, 1, 2}));
        System.out.println(p.solution(3, new int[]{1, 1}));
    }
}
