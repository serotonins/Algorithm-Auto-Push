import java.util.*;
import java.io.*;

public class Main {

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {

        int n = read();
        int answer = 0;

        int[][] dp = new int[n][10];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (int) ((long) dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
            }
        }

        for (int i = 1; i < 10; i++) {
            answer = (int) ((long) answer + dp[n-1][i]) % 1_000_000_000;
        }

        System.out.println(answer);
    }
}

