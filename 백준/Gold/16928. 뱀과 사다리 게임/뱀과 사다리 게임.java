import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visit;
    static int[] map;
    static int[][] dr = {{0,0,-1,1}, {1,-1,0,0}};
    static boolean isOut(int y, int x) {return y < 0 || y >= n || x < 0 || x >= m;}

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void mapSetting() throws IOException {
        for (int i = 0; i < 101; i++) {
            map[i] = i;
        }
        for (int i = 0; i < n+m; i++) {
            map[read()] = read();
        }
    }

    static class Node {
        int idx, cnt;
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        n = read();
        m = read();

        visit = new boolean[101];
        map = new int[101];
        mapSetting();

        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        que.add(new Node(1, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();
            if (now.idx == 100) {
                answer = now.cnt;
                break;
            }
            for (int i = 1; i <= 6; i++) {
                if (now.idx+i > 100) break;
                int next = map[now.idx+i];
                if (visit[next]) continue;
                visit[next] = true;
                que.add(new Node(next, now.cnt+1));
            }
        }

        System.out.println(answer);
    }
}

