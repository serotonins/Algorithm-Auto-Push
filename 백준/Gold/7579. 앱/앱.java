import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    
    static class App {
        int mem, cost;
        public App(int mem, int cost) {
            this.mem = mem;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        App[] arr = new App[n];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
        }

        int[][] dp = new int[n][100 * 100 + 1];
        dp[0][arr[0].cost] = arr[0].mem;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];
            if (arr[i].cost == 0) dp[i][0] += arr[i].mem;
        }
        if (dp[n-1][0] >= m) {
            System.out.println(0);
            return;
        }

        for (int c = 1; c <= 100 * 100; c++) {
            dp[0][c] = Math.max(dp[0][c-1], dp[0][c]);
            for (int i = 1; i < n; i++) {
                int temp = 0;
                if (arr[i].cost <= c) {
                    temp = dp[i-1][c-arr[i].cost] + arr[i].mem;
                }
                temp = Math.max(temp, dp[i-1][c]);
                dp[i][c] = Math.max(temp, dp[i][c-1]);
            }
            if (dp[n-1][c] >= m) {
                System.out.println(c);
                return;
            }
        }

    }
}

