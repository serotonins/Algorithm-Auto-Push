import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {

        n = read();
        k = read();

        int[] wei = new int[n+1];
        int[] val = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wei[i] = read();
            val[i] = read();
        }

        int[][] dp = new int[n+1][k+1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                if (j >= wei[i]) dp[i][j] = Math.max(dp[i-1][j], val[i] + dp[i-1][j-wei[i]]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}

