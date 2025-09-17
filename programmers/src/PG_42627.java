import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_42627 {
	public int solution(int[][] jobs) {
		int answer = 0;
		int n = jobs.length;

		// 요청 시각 오름차순(같으면 소요시간 오름차순)으로 정렬
		Arrays.sort(jobs, (a, b) -> {
			if (a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
		});

		// [작업번호, 시작 시간, 소요 시간]
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = i;
			arr[i][1] = jobs[i][0];
			arr[i][2] = jobs[i][1];
		}

		// 우선순위 큐: 소요시간 짧은 순, 같으면 요청 시각 빠른 순, 같으면 작업 번호 빠른 순
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[2] != b[2]) return a[2] - b[2];
			if (a[1] != b[1]) return a[1] - b[1];
			return a[0] - b[0];
		});

		int time = 0;
		int idx = 0;
		int doneIdx = -1;
		int total = 0;

		while (doneIdx < n) {
			// 현재 바라보고 있는 인덱스가 총 작업 개수보다 작고,
			// 현재 바라보고있는 작업의 시작 시간이 현재 시간보다 작거나 같을경우 pq에 넣기
			while (idx < n && arr[idx][1] <= time) {
				pq.offer(arr[idx++]);
			}

			if (pq.isEmpty()) {
				if (idx < n)
				time = Math.max(time, arr[idx][1]);
			} else {
				// 우선 순위가 가장 높은 작업 실행
				int[] cur = pq.poll();

				time += cur[2];
				total += cur[2];
				doneIdx++;
			}
		}

		return total / n;
	}
}
