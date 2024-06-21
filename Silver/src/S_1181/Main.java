package S_1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        String[] words = new String[set.size()];
        int idx = 0;
        for (String s : set) {
            words[idx++] = s;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
