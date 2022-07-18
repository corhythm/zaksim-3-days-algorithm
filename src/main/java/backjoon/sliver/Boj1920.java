package backjoon.sliver;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(tokenizer.nextToken()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(tokenizer.nextToken());
            if (set.contains(x)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
