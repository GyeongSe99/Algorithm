import java.util.*;

public class Main {

    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] maxSize = new int[3];

        for (int i = 0; i < maxSize.length; i++) {
            maxSize[i] = sc.nextInt();
        }

        int[] bottles = new int[3];

        bottles[2] = maxSize[2];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(bottles);
        result.add(bottles);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // i : 나누어 주려는 통
            for (int i = 0; i < now.length; i++) {
                if (now[i] != 0) {
                    // j : 나눔 받을 통
                    for (int j = 0; j < now.length; j++) {
                        // now[j]가
                        // 나누어 주려는 통이 아니고
                        // 꽉 차 있지 않은 경우
                        if (j != i && now[j] < maxSize[j]) {
                            int[] next = Arrays.copyOf(now, now.length);

                            // 옮길 물의 양
                            int water = now[i] + now[j] > maxSize[j] ? maxSize[j] - now[j] : now[i];
                            next[j] = now[j] + water;
                            next[i] = now[i] - water;

                            if (!isContains(next)) {
                                result.add(next);
                                queue.add(next);
                            }
                        }
                    }
                }
            }

        }

        List<Integer> answer = new ArrayList<>();

        for (int[] arr : result)  {
            if (arr[0] == 0) {
                answer.add(arr[2]);
            }
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();

        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    static boolean isContains(int[] pushArr) {
        boolean isSame = true;


        for (int[] arr : result) {
            isSame = true;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != pushArr[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                return true;
            }
        }

        return isSame;
    }
}