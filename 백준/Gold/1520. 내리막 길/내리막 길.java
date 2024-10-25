import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static int answer = 0;
    static int n, m;
    static int[][] arr, dp;
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};

    static boolean isOut(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }

    static int dfs(int y, int x) {
        if (y == n-1 && x == m-1) {
            return 1;
        } else if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int w = y + dr[0][i];
            int v = x + dr[1][i];
            if (isOut(w, v) || arr[y][x] <= arr[w][v]) {
                continue;
            }
            dp[y][x] += dfs(w,v);
        }

        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }
}

