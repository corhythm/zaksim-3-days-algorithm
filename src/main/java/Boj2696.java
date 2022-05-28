import java.util.Scanner;

// 백준에 제출할 때는 Main으로 class 명을 바꾸서 제출해야 함
public class Boj2696 {

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int numA = scanner.nextInt();
        int numB = scanner.nextInt();

//        numA > numB ? gcd(numA, numB) : gcd(numB, numA);

        if (numA > numB) {
            System.out.println(gcd(numA, numB));
            System.out.println(lcm(numA, numB));
        }
        else {
            System.out.println(gcd(numB, numA));
            System.out.println(lcm(numB, numA));
        }
    }

    private int gcd(final int a, final int b) { // Greatest Common Divisor
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
    private int lcm(final int a, final int b) { // Least Common Multiple
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        new Boj2696().run();
    }
}
