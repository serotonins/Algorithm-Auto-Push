import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static Set<Integer> heads;
    static ArrayList<Integer>[] fronts, backs;

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void setting() throws IOException {
        for (int i = 1; i < n+1; i++) {
            heads.add(i);
            fronts[i] = new ArrayList<>();
            backs[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int f = read();
            int b = read();
            fronts[b].add(f);
            backs[f].add(b);
            heads.remove(b);
        }
    }

    static void running(int now) {
        for (int i : fronts[now]) {
            if (visit[i]) continue;
            running(i);
        }
        if (!visit[now]) {
            sb.append(now);
            sb.append(" ");
            visit[now] = true;
        }
        for (int i : backs[now]) {
            if (visit[i]) continue;
            running(i);
        }
    }

    public static void main(String[] args) throws IOException {

        n = read();
        m = read();
        visit = new boolean[n+1];
        heads = new HashSet<>();
        fronts = new ArrayList[n+1];
        backs = new ArrayList[n+1];
        setting();

        for (int s : heads) {
            if (backs[s].isEmpty()) {
                sb.append(s);
                sb.append(" ");
                visit[s] = true;
                continue;
            } else if (visit[s]) continue;
            running(s);
        }
        System.out.println(sb.toString());
    }
}

