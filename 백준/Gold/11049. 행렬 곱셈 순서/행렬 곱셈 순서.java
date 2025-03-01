import java.util.*;
import java.io.*;

public class Main {
    static int n, inf = Integer.MAX_VALUE;
    static int[][] arr, dp;
    
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {

        n = read();
        arr = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = arr[i][0] * arr[i][1] * arr[i+1][1];
        }

        for (int dis = 2; dis < n; dis++) {
            for (int i = 0; i + dis < n; i++) {
                int j = i + dis;
                dp[i][j] = inf;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + arr[i][0] * arr[k][1] * arr[j][1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}

