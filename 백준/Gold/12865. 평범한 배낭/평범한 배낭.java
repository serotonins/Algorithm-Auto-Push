import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int [n][k+1];
        for (int i = 0; i < n; i++) {
            // 현재 탐색하는 물건의 무게만큼을 뺀 열(무게)의 현재 탐색 물건의 전 행(물건 번호)(중복 선택 방지)
            for (int j = 1; j < k+1; j++) {
                if (weight[i] <= j) dp[i][j] = value[i];
                if (j-weight[i] > 0 && i > 0) dp[i][j] += dp[i-1][j-weight[i]];
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }

        System.out.println(dp[n-1][k]);

    }
}

