import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2750 {

    /**
     * https://www.acmicpc.net/problem/2750
     * 수 정렬하기
     */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            System.out.println("input");
            int value = System.in.read();
            System.out.println("value = " + value);
            numList.add(value);
        }

        numList.stream()
                .sorted()
                .forEach(System.out::println);

    }

}