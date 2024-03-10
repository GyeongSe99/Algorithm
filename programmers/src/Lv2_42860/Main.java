package Lv2_42860;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public int solution(String name) {
        int answer = 0;
        char[] arr = new char[name.length()];
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            // 집어넣어야 하는 알파벳. 필요한 상하 이동 횟수 찾기
            int alphaMove = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += alphaMove;

            int next = i + 1;
            // 다음 볼 인덱스의 문자가 'A'라면 따로 연산이 필요하지 않기 때문에 인덱스를 늘려줌
            while (i < name.length() - 1 && name.charAt(next) == 'A') {
                next++;
            }

            // 그냥 쭉 오른쪽으로 갔을때 좌우로 이동하는 거리 = name.length - 1
            // 돌아가는 총 거리 = 앞으로 간거리 i + 돌아온 거리 i + 돌아서 왔을때 우로 이동해야하는 거리(name.length() - next)
            move = Math.min(move, (i * 2) + name.length() - next);
        }

        return answer + move;
    }
}
