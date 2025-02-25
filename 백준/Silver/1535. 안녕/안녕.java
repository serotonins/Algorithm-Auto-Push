import java.util.*;
import java.io.*;

public class Main {
    static int n;

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {

        n = read();

        int[] life = new int[n+1];
        int[] joy = new int[n+1];
        for (int i = 1; i <= n; i++) {
            life[i] = read();
        }
        for (int i = 1; i <= n; i++) {
            joy[i] = read();
        }

        int[][] dp = new int[n+1][101];
        for (int j = 2; j < 101; j++) {
            for (int i = 1; i <= n; i++) {
                if (j > life[i]) {
                    dp[i][j] = joy[i];
                    if (j-life[i] > 0) {
                        dp[i][j] += dp[i-1][j-life[i]];
                    }
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        System.out.println(dp[n][100]);
    }
}

