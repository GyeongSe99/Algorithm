import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S_1316 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> set;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set = new HashSet<>();
            int idx = 0;
            char prev = '.';
            boolean isGroupWord = true;

            while (idx < s.length()) {
                char now = s.charAt(idx);

                if (!set.contains(now)) {   // 한번도 등장하지 않은 문자라면
                    set.add(now);
                    prev = now;
                } else { // 등장했던 문자라면
                    if (prev != now) {
                        isGroupWord = false;
                        break;
                    }
                }
                idx++;
            }

            if (isGroupWord) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}
