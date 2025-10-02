import java.io.IOException;
import java.util.*;

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

    static class Work implements Comparable<Work> {
        int d, t, p;

        public Work(int d, int t, int p) {
            this.d = d + 1;
            this.t = d + t;
            this.p = p;
            if (this.t > n) this.p = 0;
        }

        public String toString() {
            return "@ " + d + "일 ~ " + t + "일까지 - " + p + "원..";
        }

        @Override
        public int compareTo(Work o) {
            if (this.t == o.t) {
                if (this.p == o.p) return o.d - this.d;
                else return o.p - this.p;
            }
            return this.t - o.t;
        }
    }

    public static void main(String[] args) throws IOException {
        n = read();

        PriorityQueue<Work> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            que.add(new Work(i, read(), read()));
        }

        int[] dp = new int[n+1];
        int day = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            Work now = que.poll();
            int sta = now.d;
            int due = now.t;
            int pay = now.p;

            if (due <= n) {
                // 현재 상담 전까지 && 현재 상담 시작일 전까지
                dp[due] = Math.max(dp[due], pay + dp[Math.min(sta-1, day)]);
                if (max < dp[due]) {
                    max = Math.max(max, dp[due]);
                    for (int j = day; j < due; j++) {
                        dp[j] = Math.max(dp[j], dp[j-1]);
                    }
                    day = due;
                }
            } else break;
        }

        System.out.println(max);
    }
}