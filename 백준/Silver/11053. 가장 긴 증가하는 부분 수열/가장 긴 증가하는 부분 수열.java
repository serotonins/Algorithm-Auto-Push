import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] maxi = new int[n];
        maxi[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (sequence[j] >= sequence[i] || dp[j] < dp[i]) {continue;}
                dp[i] = dp[j] + 1;
                if (dp[j] == maxi[i-1]) break;
            }
            maxi[i] = Math.max(maxi[i-1], dp[i]);
        }

        System.out.println(maxi[n-1]);
    }
}

