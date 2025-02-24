import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
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
        m = read();

        Queue<Integer> que = new LinkedList<>();
        int[] answer = new int[n];
        int[] parents = new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int idx = 0;
        for (int i = 0; i < m; i++) {
            int k = read();
            int pre = read();
            for (int j = 0; j < k - 1; j++) {
                int now = read();
                parents[now]++;
                graph[pre].add(now);
                pre = now;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (parents[i] == 0) que.add(i);
        }
        boolean[] visit = new boolean[n+1];
        while (!que.isEmpty()) {
            int now = que.poll();
            answer[idx++] = now;
            visit[now] = true;
            for (int i : graph[now]) {
                if (--parents[i] == 0 && !visit[i]) que.add(i);
            }
        }
        if (idx != n) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

