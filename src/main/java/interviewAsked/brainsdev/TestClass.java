package interviewAsked.brainsdev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class TestClass {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int N = Integer.parseInt(sc.nextLine());

            int best = 0;
            int bestAbs = Integer.MAX_VALUE;


            while (N-- > 0) {
                int val = sc.nextInt();
                int curAbs = Math.abs(val);

                if (curAbs < bestAbs || (curAbs == bestAbs && val > best)) {
                    best = val;
                    bestAbs = curAbs;
                }
            }

            System.out.println(best);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
