import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_3009 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();

        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            if (setX.contains(x)) {
                setX.remove(x);
            } else {
                setX.add(x);
            }

            if (setY.contains(y)) {
                setY.remove(y);
            } else {
                setY.add(y);
            }
        }

        System.out.println(setX.iterator().next() + " " + setY.iterator().next());

    }

}
