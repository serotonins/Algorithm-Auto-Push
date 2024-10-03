import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dp = new int[31][31];
        for (int i = 0; i < 31; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i < 31; i++) {
            for (int j = 2; j < 31; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.append(dp[m][n] + "\n");
        }

        bw.flush();
        bw.close();

    }
}

