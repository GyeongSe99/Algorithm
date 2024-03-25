package B_1236;
// https://www.acmicpc.net/problem/1236
// 백준 1236 : 성 지키기

/*
해설 : 가로 쪽에 필요한 경비병의 수와 세로쪽에 필요한 경비병의 수를 구한다
만약 가로에 3개 세로에 1개가 필요하다고 하면, 3부분의 가로중 하나와 세로 1개가 겹치는 곳에 경비병을 배치하면
나머지 가로에는 아무데나 하나씩 배치하면된다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static char[][] castle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rowLength = nums[0];
        int colLength = nums[1];

        castle = new char[nums[0]][nums[1]];

        // 성 배열 만들기
        for (int i = 0; i < rowLength; i++) {
            String s = br.readLine();

            for (int j = 0; j < colLength; j++) {
                castle[i][j] = s.charAt(j);
            }
        }

        // 경비병이 필요한 수 찾기
        boolean[] row = new boolean[rowLength];
        boolean[] col = new boolean[colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (castle[i][j] == 'X'){
                    // 현재 보고 있는 줄에 경비병이 발견되면
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 경비병이 필요한 곳 개수 구하기
        int rowCnt = 0;
        int colCnt = 0;

        for (int i = 0; i < rowLength; i++) {
            if (!row[i]) {
                rowCnt++;
            }
        }

        for (int i = 0; i < colLength; i++) {
            if (!col[i]) {
                colCnt++;
            }
        }

        // 최대값이 곧 경비병이 필요한 최소 숫자
        System.out.println(Math.max(rowCnt, colCnt));
    }

    /**
     * 성 모양대로 배열 출력하기
     */
    public static void printCastle() {
        for (int i = 0; i < castle.length; i++) {
            for (int j = 0; j < castle[0].length; j++) {
                System.out.print(castle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 경비병이 필요한 곳을 마킹해둔 boolean 배열 출력
     * 어디가 false 로 마킹되어있는지 보기 위함
     *
     * @param arr : row Boolean Array, col Boolean Array
     */
    public static void printBooleanArr(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}