import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, inf = 10001;
    static int[] dp;
    static boolean[] visit;
    static List<Integer> coins = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static int find(int target) {
        if (target == 0) return 0;
        else if (visit[target]) return dp[target];

        for (int v : coins) {
            if (target < v) break;
            dp[target] = Math.min(dp[target], find(target - v) + 1);
        }

        visit[target] = true;
        return dp[target];
    }

    public static void main(String[] args) throws IOException {
        n = read();
        k = read();

        dp = new int[k+1];
        visit = new boolean[k+1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int coin = read();
            if (coin > k) continue;
            set.add(coin);
            visit[coin] = true;
            dp[coin] = 1;
        }
        coins.addAll(set);
        Collections.sort(coins);

        int answer = find(k);

        System.out.println(answer == inf ? -1 : answer);
    }
}