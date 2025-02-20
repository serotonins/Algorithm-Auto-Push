import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static int[] parents;
    static Set<Integer> heads;
    static ArrayList<Integer>[] backs;

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
            backs[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int f = read();
            int b = read();
            backs[f].add(b);
            heads.remove(b);
            parents[b]++;
        }
    }

    public static void main(String[] args) throws IOException {

        n = read();
        m = read();
        parents = new int[n+1];
        heads = new HashSet<>();
        backs = new ArrayList[n+1];
        setting();

        Queue<Integer> que = new LinkedList<>(heads);

        while (!que.isEmpty()) {
            int now = que.poll();
            sb.append(now).append(" ");
            for (int i : backs[now]) {
                if (--parents[i] == 0) {
                    que.add(i);
                }
            }
        }

        System.out.println(sb.toString());
    }
}

