package backjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");

        int res = 0;

        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                if (split[i].contains("+")) {
                    String[] subSplit = split[i].split("\\+");
                    for (String s : subSplit) {
                        res += Integer.parseInt(s);
                    }
                } else {
                    res += Integer.parseInt(split[i]);
                }
                continue;
            }

            if (split[i].contains("+")) {
                String[] subSplit = split[i].split("\\+");
                for (String s : subSplit) {
                    res -= Integer.parseInt(s);
                }
            } else {
                res -= Integer.parseInt(split[i]);
            }
        }

        System.out.println(res);
    }
}
