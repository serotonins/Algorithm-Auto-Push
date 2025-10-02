import java.io.IOException;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        n = read();

        int[][] works = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                works[i][j] = read();
            }
        }

        int[] dp = new int[n+51];
        for (int i = n; i >= 1; i--) {
            dp[i] = Math.max(dp[i], dp[i+1]);
            if (i + works[i][0] <= n + 1) dp[i] = Math.max(dp[i], dp[i + works[i][0]] + works[i][1]);
        }

        System.out.println(dp[1]);
    }
}