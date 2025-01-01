import java.util.*;
import java.io.*;

public class Main {
    static int n, k, inf = Integer.MAX_VALUE;
    static int[] arr;
    static int[] dp;
    static List<Integer>[] series;

    static int construct(int num) {
        if (series[num].isEmpty()) return arr[num];
        if (dp[num] != -1) return dp[num];
        int time = 0;
        for (int i : series[num]) {
            time = Math.max(time, construct(i));
        }
        return dp[num] = arr[num] + time;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            dp = new int[n+1];
            Arrays.fill(dp, -1);
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            series = new ArrayList[n+1];
            for (int i = 1; i < n + 1; i++) {
                series[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                series[two].add(one);
            }
            // 재귀 함수
            sb.append(construct(Integer.parseInt(br.readLine()))+"\n");
        }

        System.out.println(sb.toString());
    }
}

