package S_8979;

// 1. 배열의 0번에 나라번호, 그 이후로 금은동 순서대로 넣기
// 2. 금 -> 은 -> 동 순서대로 값 비교하는 comparator만들기 (혹시 또 쓸 수 있을까봐 따로 만듦)
// 3. Array.sort(arr, comparator)메소드 이용하여 정렬한 후
// 4. arr 순서대로 돌면서 이전 메달과 현재 메달 비교. rank를 + 1 해줘야하는지 or 공동 rank인지 아닌지 확인
// 5. 반복문 마지막에 내가 찾는 나라라면 break

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Comparator<int[]> myComparator = (o1, o2) -> {
            int compare = Integer.compare(o2[1], o1[1]);
            if (compare == 0) {
                compare = Integer.compare(o2[2], o1[2]);
                if (compare == 0) {
                    compare = Integer.compare(o2[3], o1[3]);
                }
            }
            return compare;
        };

        Arrays.sort(arr, myComparator);

        int rank = 1;
        int curRank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                int[] prev = arr[i - 1];
                int[] curr = arr[i];

                if (prev[1] == curr[1] && prev[2] == curr[2] && prev[3] == curr[3]) {
                }
                else curRank = i + 1;
            }
            rank = curRank;

            if (arr[i][0] == K) {
                break;
            }
        }

        System.out.println(rank);
    }
}
