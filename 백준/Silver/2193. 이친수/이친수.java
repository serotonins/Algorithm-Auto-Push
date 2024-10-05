import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if (n < 3) {
            System.out.println(1);
            return;
        }

        long[][] dp = new long[91][2];
        dp[2][0] = 1;
        for (int i = 3; i < 91; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[n][0]+dp[n][1]);
//        bw.flush();
//        bw.close();

    }
}

