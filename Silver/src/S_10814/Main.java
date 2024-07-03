package S_10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Person {
        int id;
        int age;
        String name;

        public Person(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] list = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Person p = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
            list[i] = p;
        }

        Arrays.sort(list, (o1, o2) -> o1.age - o2.age == 0 ? o1.id - o2.id : o1.age - o2.age);

        for (int i = 0; i < N; i++) {
            Person p = list[i];
            System.out.println(p.age + " " + p.name);
        }
    }
}
