package backjoon.sliver;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2740 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(br.readLine());
        int M2 = Integer.parseInt(tokenizer.nextToken()); // equals to M
        int K = Integer.parseInt(tokenizer.nextToken());
        int[][] B = new int[M2][K];

        for (int i = 0; i < M2; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] C = new int[N][K];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
                sb.append(C[i][j]).append(" ");
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();

        bw.close();
        br.close();
    }
}
