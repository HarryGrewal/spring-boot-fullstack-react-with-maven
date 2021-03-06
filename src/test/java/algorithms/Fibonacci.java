package algorithms;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        final int fib = fib(Integer.parseInt(new Scanner(System.in).nextLine()));
        System.out.println(fib);
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
