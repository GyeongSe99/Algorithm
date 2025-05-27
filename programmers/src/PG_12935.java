public class PG_12935 {

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] answer = new int[arr.length - 1];

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                minIdx = i;
                min = arr[i];
            }
        }

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }

            answer[idx++] = arr[i];
        }

        return answer;
    }

}
