import java.util.*;
import java.io.*;

public class Main {
    static int[] lim;
    static TreeSet<Integer> set = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static class Water {
        int[] abc = new int[4];
        public Water(int[] abc) {
            for (int i = 1; i < 4; i++) {
                this.abc[i] = abc[i];
            }
        }
    }

    static Water pour(Water now, int dep, int arr) {
        Water next = new Water(now.abc);
        int dir = Math.min(lim[arr] - now.abc[arr], now.abc[dep]);
        next.abc[dep] -= dir;
        next.abc[arr] += dir;
        return next;
    }

    public static void main(String[] args) throws IOException {
        
        lim = new int[4];
        for (int i = 1; i < 4; i++) {
            lim[i] = read();
        }

        boolean[][][] visit = new boolean[lim[1]+1][lim[2]+1][lim[3]+1];
        visit[0][0][lim[3]] = true;

        Queue<Water> que = new LinkedList<>();
        que.add(new Water(new int[] {0,0,0,lim[3]}));
        set.add(lim[3]);
        while (!que.isEmpty()) {
            Water now = que.poll();
            for (int d = 1; d <= 3; d++) {
                for (int a = 1; a <= 3; a++) {
                    if (d == a) continue;
                    Water next = pour(now, d, a);
                    if (visit[next.abc[1]][next.abc[2]][next.abc[3]]) continue;
                    visit[next.abc[1]][next.abc[2]][next.abc[3]] = true;
                    if (next.abc[1] == 0) set.add(next.abc[3]);
                    que.add(next);
                }
            }
        }

        for (int i : set) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}

