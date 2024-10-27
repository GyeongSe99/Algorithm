package Lv_43163;

public class PG_43163 {

    private int min = Integer.MAX_VALUE;

    private int solution(String begin, String target, String[] words) {
        int[] visited = new int[words.length];

        this.dfs(target, words, visited, begin, 0);

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * begin에서 target으로 변환하기 위한 최소 변환 횟수
     * words에 있는 단어로만 변환 가능
     * 한 번에 한 개의 알파벳만 바꿀 수 있음
     *
     * @param target : 찾고자 하는 문자열
     * @param words : 단어 리스트
     * @param begin : 시작 단어
     * @param cnt : 변환 횟수
     */
    private void dfs(String target, String[] words, int[] visited, String begin, int cnt) {
        if (cnt > words.length) {
            return;
        }

        if (cnt > min) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 한 글자만 다르다면 dfs 호출
            if (visited[i] == 0) {
                System.out.println("------------------------");
                System.out.println("begin = " + begin);
                System.out.println("word = " + word);
                System.out.println("cnt = " + cnt);

                if (isOneDiff(begin, word)) {
                    if (target.equals(word)) {
                        // target과 words[i]가 같다면 min값 갱신
                        this.min = Math.min(min, cnt + 1);
                        System.out.println("check : " + this.min);
                    } else {
                        visited[i] = 1;
                        System.out.println("cnt + 1 = " + (cnt + 1));
                        dfs(target, words, visited, word,cnt + 1);
                        visited[i] = 0;
                    }

                }

            }
        }
    }

    // 한글자만 다른지 확인
    private boolean isOneDiff(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) throws Exception {
        PG_43163 solution = new PG_43163();
        int answer = solution.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);

    }

}
