package B_2309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> p = new ArrayList<>();

        int totalSum = 0;
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            p.add(num);
            totalSum += num;
        }

        out: for (int i = 0; i < p.size(); i++) {
            for (int j = i + 1; j < p.size(); j++) {
                if (totalSum - p.get(i) - p.get(j) == 100) {
                    p.remove(j);
                    p.remove(i);

                    Collections.sort(p);
                    for (Integer num : p) {
                        System.out.println(num);
                    }
                    break out;
                }
            }
        }
        
    }
}
