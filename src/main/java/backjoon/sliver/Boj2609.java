package backjoon.sliver;

import java.util.Scanner;

public class Boj2609 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numA = scanner.nextInt();
        int numB = scanner.nextInt();

        if (numA > numB) {
            System.out.println(gcd(numA, numB));
            System.out.println(lcm(numA, numB));
        }
        else {
            System.out.println(gcd(numB, numA));
            System.out.println(lcm(numB, numA));
        }
    }

    private static int gcd(final int a, final int b) { // Greatest Common Divisor
        int n;

        int numA = a;
        int numB = b;

        while (numB != 0) {
            n = numA % numB;
            numA = numB;
            numB = n;
        }
        return numA;
    }

    // 최소공배수 == 두 수의 곱 / 최대공약수
    private static int lcm(final int a, final int b) { // Least Common Multiple
        return a * b / gcd(a, b);
    }
}
